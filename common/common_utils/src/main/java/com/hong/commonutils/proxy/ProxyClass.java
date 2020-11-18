package com.hong.commonutils.proxy;

public class ProxyClass implements Programmer {
    public TargetClass targetClass;
    public ProxyClass(){
        this.targetClass = new TargetClass();
    }
    public void custom(){
        System.out.println("自定义的增强/限制的方法");
    }
    @Override
    public void coding() {
        targetClass.coding();
        custom();
    }
}
