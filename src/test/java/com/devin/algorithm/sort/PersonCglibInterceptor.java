package com.devin.algorithm.sort;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * </p>
 *
 * @author hkh
 * @since 2020/9/15
 */
public class PersonCglibInterceptor<T> implements MethodInterceptor {
    private T target;

    public PersonCglibInterceptor(T target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib proxy start ");
        method.invoke(target, objects);
        System.out.println("cglib proxy end");
        return null;
    }
}
