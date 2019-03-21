package com.study.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义聚合类
 */
public class ConcreteMyAggregate {
    private List<Object> list = new ArrayList<Object>();

    public void addObject(Object object) {
        this.list.add(object);
    }

    public void removeObject(Object object) {
        this.list.remove(object);
    }

    public MyIterator createMyIterator() {
        return new ConcreteIterator();
    }

    /**
     * 使用内部类定义迭代器，可以直接使用外部属性
     */
    private class ConcreteIterator implements MyIterator {

        private int cursor;  //定义游标，用于记录遍历时的位置

        public void first() {
            cursor = 0;
        }

        public void next() {
            if (cursor < list.size()) {
                cursor++;
            }
        }

        public boolean hasNext() {
            if (cursor < list.size() - 1) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isFirst() {
            return cursor == 0;
        }

        public boolean isLast() {
            return cursor == (list.size() - 1);
        }

        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }

}
