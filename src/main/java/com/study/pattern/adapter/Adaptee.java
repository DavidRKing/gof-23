package com.study.pattern.adapter;

/**
 * 被适配的类
 * （PS/2键盘）
 */
public class Adaptee {
    public void request() {
        System.out.println("可以完成打字功能");
    }
}
