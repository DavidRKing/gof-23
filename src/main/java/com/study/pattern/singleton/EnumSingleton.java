package com.study.pattern.singleton;

/**
 * 枚举 (没有掩饰加载)
 */
public enum EnumSingleton {
    //枚举元素本身就是单利
    INSTANCE;

    //添加自己需要的操作
    public void singletonOperation() {

    }

    public static void main(String[] args) {
        EnumSingleton.INSTANCE.singletonOperation();
    }
}
