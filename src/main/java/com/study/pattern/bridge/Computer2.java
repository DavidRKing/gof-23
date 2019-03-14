package com.study.pattern.bridge;

public class Computer2 {
    protected Brand brand;

    public Computer2(Brand b) {
        this.brand = b;
    }

    public void sales() {
        brand.sales();
    }
}

class Desktop2 extends Computer2 {

    public Desktop2(Brand b) {
        super(b);
    }

    public void sales() {
        super.sales();
        System.out.println("销售台式机");
    }
}

class Laptop2 extends Computer2 {

    public Laptop2(Brand b) {
        super(b);
    }

    public void sales() {
        super.sales();
        System.out.println("销售笔记本");
    }
}


