package com.study.pattern.proxy.dynamicproxy;

import java.io.ObjectInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {

    private Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        if (method.getName().equals("sing")) {
            System.out.println("proxy......");
            obj = method.invoke(realStar, args);
            System.out.println("proxy......");
        } else {
            System.out.println("除了唱歌，其他方法不代理");
        }
        return obj;
    }
}
