package com.study.pattern.flyweight;

/**
 * 享元模式场景
 * <p>
 * 线程池，数据库连接池
 * <p>
 * 极大介绍内存中对象的数量
 * <p>
 * 相同或相似对象内存中只存一份，极大的节约资源，提高系统性能
 * 外部状态相对独立，不影响内部状态
 * <p>
 * 缺点：
 * 模式较复杂，使用程序逻辑复杂化
 * 为了节省内存，共享了内部状态，分离出外部状态，而读取外部状态
 * 使运行时间变长。用时间换区了空间。
 */
public class Client {
    public static void main(String[] args) {
        ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
        ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("黑色");

        System.out.println(chess1);
        System.out.println(chess2);

        System.out.println("增加外部状态的处理");

        chess1.display(new Coordinate(10, 10));
        chess2.display(new Coordinate(20, 20));


    }
}
