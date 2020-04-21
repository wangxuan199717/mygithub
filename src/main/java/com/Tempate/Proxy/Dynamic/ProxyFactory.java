package com.Tempate.Proxy.Dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object object;
    public ProxyFactory(Object o){
        this.object=o;
    }

    public Object getProxyInstance(){
        ClassLoader classLoader = object.getClass().getClassLoader();
        Class<?>[] interfaces = object.getClass().getInterfaces();
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            System.out.println("JDK 代理启动");
            Object result = method.invoke(object,args);
            return result;
        };
        Object proxyObject = Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
        return proxyObject;
    }
}
