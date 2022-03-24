package com.example.javahans.proxy.handel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DebugInvocationHandler  implements InvocationHandler {
    private final Object object;
    public DebugInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before send message:" + method.getName());
        Object result = method.invoke(object, args);
        System.out.println("after send message:" + method.getName());
        return result;
    }
}
