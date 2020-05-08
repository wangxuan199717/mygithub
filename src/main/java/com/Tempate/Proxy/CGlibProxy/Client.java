package com.Tempate.Proxy.CGlibProxy;


public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new TeacherDao());
        TeacherDao object =(TeacherDao) proxyFactory.getProxyInstance();
        object.teach();
        object.homework();
    }
}
