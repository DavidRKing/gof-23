package com.study.pattern.adapter;

/**
 * 适配器 (类适配器方式  如果需要继承其他的类，就不行了)
 * （相当于USB和PS/2的转接器）
 */
public class Adapter extends Adaptee implements Target {

    public void handleRequest() {
        super.request();
    }
}
