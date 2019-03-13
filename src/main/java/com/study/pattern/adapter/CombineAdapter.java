package com.study.pattern.adapter;

/**
 * 适配器（对象适配器，使用了组合的方式跟被适配对象）
 */
public class CombineAdapter implements Target {

    private Adaptee adaptee;

    public CombineAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void handleRequest() {
        adaptee.request();
    }
}
