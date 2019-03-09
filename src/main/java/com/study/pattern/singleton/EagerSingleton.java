package com.study.pattern.singleton;

/**
 * 饿汉模式
 * <p>
 * 天然线程安全，调用效率高，无延时加载
 */
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        EagerSingleton s1 = EagerSingleton.getInstance();
        EagerSingleton s2 = EagerSingleton.getInstance();
        System.out.println(s1 == s2);
    }
}
