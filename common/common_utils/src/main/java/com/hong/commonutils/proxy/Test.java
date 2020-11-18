package com.hong.commonutils.proxy;

import java.lang.reflect.Proxy;
/*
静态代理和动态代理的区别：
    1.静态代理需要自己写代理类（代理类需要实现与目标对象相同的接口）
      动态代理不需要自己编写代理类
    2.静态代理：如果目标对象的接口有很多方法的话，静态代理就需要一一实现
      动态代理：代理对象的生成，是利用JDK API，动态地在内存中创建代理对象（需要我们指定
                创建 代理对象/目标对象 实现的接口的类型），并且会默认实现接口的全部方法
* */
public class Test {
    public static void main(String[] args1) {
        //静态代理
/*        ProxyClass proxyClass = new ProxyClass();
        proxyClass.coding();*/

        //动态代理
        TargetClass targetClass = new TargetClass();
        Programmer programmer = (Programmer) Proxy.newProxyInstance(targetClass.getClass().getClassLoader(), targetClass.getClass().getInterfaces(), (proxy,method,args)->{
            if(method.getName().equals("coding")){
                method.invoke(targetClass,args);
            }else {
                return method.invoke(targetClass,args);
            }
            return null;
        });
        programmer.coding();
    }
}
