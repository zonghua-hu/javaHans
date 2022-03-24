package com.example.javahans.proxy.handel;

import java.lang.reflect.Proxy;

/**
 * 代理工厂
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target)
    {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DebugInvocationHandler(target)
        );
    }
}
