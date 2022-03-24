package com.example.javahans.proxy.jdkProxy;

import com.example.javahans.proxy.alisms.AliSmsMethodInterceptor;
import net.sf.cglib.proxy.Enhancer;

public class HansProxyFactory
{
    public static Object getProxy(Class<?> clazz)
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new AliSmsMethodInterceptor());
        return enhancer.create();
    }
}
