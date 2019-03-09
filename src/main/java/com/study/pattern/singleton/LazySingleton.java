package com.study.pattern.singleton;

/**
 * 懒汉式
 * 延时加载，懒加载。真正用到的时候才加载
 * <p>
 * 资源利用率高，但是，每次调用getInstance()方法都要同步，并发效率低
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        //防止反射调用
//        if (instance != null) {
//            throw new Exception("非法调用");
//        }
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}


