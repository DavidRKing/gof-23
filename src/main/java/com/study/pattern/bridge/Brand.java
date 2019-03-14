package com.study.pattern.bridge;

public interface Brand {
    public void sales();
}

class Lenovo implements Brand {

    public void sales() {
        System.out.println("销售联想电脑");
    }
}

class Dell implements Brand {

    public void sales() {
        System.out.println("销售戴尔电脑");
    }
}