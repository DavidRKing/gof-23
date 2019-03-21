package com.study.pattern.iterator;

/**
 * 迭代器接口
 */
public interface MyIterator {
    //游标指向第一个
    void first();

    //游标指向下一个
    void next();

    boolean hasNext();

    boolean isFirst();

    boolean isLast();

    /**
     * 获取当前对象
     *
     * @return
     */
    Object getCurrentObj();
}
