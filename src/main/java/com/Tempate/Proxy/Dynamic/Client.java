package com.Tempate.Proxy.Dynamic;

public class Client {
    public static void main(String[] args) {
        ITeacherDao iTeacherDao = new TeacherDao();
        ProxyFactory proxyFactory = new ProxyFactory(iTeacherDao);
        ITeacherDao object = (ITeacherDao) proxyFactory.getProxyInstance();
        object.teach();
        object.homework();
        System.out.println(object.getClass());
    }
}
