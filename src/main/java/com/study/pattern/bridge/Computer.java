package com.study.pattern.bridge;

/**
 * 桥连接模式
 * 多级层次结构  电脑- 台式机，笔记本，平板-联想台式。。。。 神州台式。。。
 *
 * 可扩展性 非常繁琐
 *
 */
public interface Computer {
    void sales();
}

class Desktop implements Computer {

    public void sales() {
        System.out.println("销售台式机");
    }
}

class Laptop implements Computer {

    public void sales() {
        System.out.println("销售笔记本");
    }
}

class Pad implements Computer {

    public void sales() {
        System.out.println("销售平板电脑");
    }
}

class LenovoDesktop extends Desktop {
    @Override
    public void sales() {
        System.out.println("销售联想台式机");
    }
}

class LenovoLaptop extends Laptop {
    @Override
    public void sales() {
        System.out.println("销售联想笔记本");
    }
}

class LenovoPad extends Laptop {
    @Override
    public void sales() {
        System.out.println("销售联想平板电脑");
    }
}


class ShenZhouDesktop extends Desktop {
    @Override
    public void sales() {
        System.out.println("销售神州台式机");
    }
}

class ShenZhouLaptop extends Laptop {
    @Override
    public void sales() {
        System.out.println("销售神州笔记本");
    }
}

class ShenZhouPad extends Laptop {
    @Override
    public void sales() {
        System.out.println("销售神州平板电脑");
    }
}

