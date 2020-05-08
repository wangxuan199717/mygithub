package com.Tempate.Proxy.CGlibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private Object object;
    public ProxyFactory(Object object){
        this.object=object;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {

        if(method.getName()=="teach")
            System.out.println("CGlib 代理类开启 ！ 代理了"+method.getName()+" 方法");
        if(method.getName()=="homework")
            System.out.println(method.getName()+"方法，我们不代理");
        Object o1 = method.invoke(object,args);
        return o1;
    }

    //返回object的cglib代理对象
    public Object getProxyInstance(){
        Enhancer enhancer= new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
}
