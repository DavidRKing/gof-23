package com.study.pattern.singleton;

import java.lang.reflect.Constructor;

public class TestClient {

    public void invokePrivate() throws Exception {
        System.out.println("通过反射调用构造函数，创建两个对象");
        Class<LazySingleton> clazz = (Class<LazySingleton>) Class.forName("com.study.pattern.singleton.LazySingleton");
        Constructor<LazySingleton> c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);
        LazySingleton s1 = c.newInstance();
        LazySingleton s2 = c.newInstance();
        System.out.println("s1 s2 是否为同一个对象? " + (s1 == s2));
    }

    public static void main(String[] args) throws Exception {
        TestClient client = new TestClient();
        client.invokePrivate();
    }
}
