package com.study.pattern.iterator;

/**
 * 实现正向遍历迭代器。
 * 实现逆向遍历迭代器
 * <p>
 * list/set中使用
 */
public class Client {
    public static void main(String[] args) {
        ConcreteMyAggregate cma = new ConcreteMyAggregate();
        cma.addObject("aa");
        cma.addObject("bb");
        cma.addObject("cc");

        MyIterator iterator = cma.createMyIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.getCurrentObj());
            iterator.next();
        }
    }
}
