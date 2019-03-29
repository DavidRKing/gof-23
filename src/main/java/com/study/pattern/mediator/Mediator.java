package com.study.pattern.mediator;

/**
 * 中介者模式
 */
public interface Mediator {
    void register(String dname, Department d);

    void command(String dname);
}
