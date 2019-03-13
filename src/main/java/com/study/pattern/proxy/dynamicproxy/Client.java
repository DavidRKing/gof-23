package com.study.pattern.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Star star = new RealStar();

        StarHandler handler = new StarHandler(star);

        Star starProxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Star.class}, handler);

        starProxy.bookTicket();
        starProxy.sing();
    }
}
