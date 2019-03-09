package com.study.pattern.singleton;

/**
 * 双重检测
 */
public class DoubleCheckSingleton {
    //
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
    }

    private static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
