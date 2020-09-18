package com.devin.algorithm.sort;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>
 *
 * </p>
 *
 * @author hkh
 * @since 2020/9/15
 */
public class PersonInvocationHandler<T> implements InvocationHandler {
    private T target;

    public PersonInvocationHandler(T target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method);
        System.out.println("动态代理开始");
        method.invoke(target, args);
        System.out.println("动态代理结束");
        return null;
    }
}
