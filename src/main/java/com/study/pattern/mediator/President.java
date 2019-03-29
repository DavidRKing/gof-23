package com.study.pattern.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * 中介者模式将 交叉的网络关系，抓换成星型的网络关系
 * 总经理
 */
public class President implements Mediator {

    private Map<String, Department> map = new HashMap<String, Department>();

    public void register(String dname, Department d) {
        map.put(dname, d);
    }

    public void command(String dname) {
        map.get(dname).selfAction();
    }
}
