package com.study.pattern.singleton;

/**
 * 静态内部类
 * <p>
 * 懒加载
 * 线程安全
 * 调用效率高
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {

    }

    private static class InnerSingletonClass {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton getInstance() {
        return InnerSingletonClass.instance;
    }
}
