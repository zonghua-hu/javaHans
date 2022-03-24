package com.example.javahans.proxy.alisms;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class AliSmsMethodInterceptor implements MethodInterceptor
{
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("jdk before send message:" + method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("jdk after send message:" + method.getName());
        return result;
    }
}
