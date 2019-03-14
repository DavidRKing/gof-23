package com.study.pattern.bridge;

/**
 * 独立扩展，方便
 * 多个变化维度 考虑桥接模式
 *
 */
public class Client {
    public static void main(String[] args) {
        //销售联想笔记本电脑
        Computer2 c = new Laptop2(new Lenovo());
        c.sales();
    }
}
