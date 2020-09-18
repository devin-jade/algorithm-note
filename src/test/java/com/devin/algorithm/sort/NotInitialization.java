package com.devin.algorithm.sort;

import net.sf.cglib.proxy.Enhancer;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * <p>
 *
 * </p>
 *
 * @author hkh
 * @since 2020/9/10
 */
public class NotInitialization {
    public static void main(String[] args) throws Exception {
        saveGeneratedJdkProxyFiles();
        Class<?> clazz = Class.forName("com.devin.algorithm.sort.Person");

//        IPerson o = (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),
//                new PersonInvocationHandler(clazz.newInstance()));
//        o.print();
//
//        Class<?> proxyClass = Proxy.getProxyClass(IPerson.class.getClassLoader(), new Class<?>[]{IPerson.class});
//        Constructor<?> ProxyConstructor = proxyClass.getConstructor(InvocationHandler.class);
//        IPerson person = (IPerson) ProxyConstructor.newInstance(new PersonInvocationHandler(clazz.newInstance()));
//        saveClass(proxyClass.getName(), proxyClass.getInterfaces(), "C:/Desktop/temp/");

        Person target = (Person)clazz.getConstructor().newInstance();
        Enhancer enhancer = new Enhancer();
        /*
         * 为代理类指定需要代理的类，也即是父类
         */
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器回调引用，对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept() 方法进行拦截
        enhancer.setCallback(new PersonCglibInterceptor(target));
        IPerson cglib = (IPerson) enhancer.create();
        cglib.print();
    }


    public static void saveClass(String className, Class<?>[] interfaces, String pathdir) {
        /*
         * 第一个参数是 代理类 名 。
         * 第二个参数是 代理类需要实现的接口
         */
        byte[] classFile = ProxyGenerator.generateProxyClass(className, interfaces);
        /*
         * 如果目录不存在就新建所有子目录
         */
        Path path1 = Paths.get(pathdir);
        if (!path1.toFile().exists()) {
            path1.toFile().mkdirs();
        }
        String path = pathdir + className + ".class";
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
    }

    /**
     * 设置保存Java动态代理生成的类文件。
     *
     * @throws Exception
     */
    public static void saveGeneratedJdkProxyFiles() throws Exception {
        Field field = System.class.getDeclaredField("props");
        field.setAccessible(true);
        Properties props = (Properties) field.get(null);
        props.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    }

}
