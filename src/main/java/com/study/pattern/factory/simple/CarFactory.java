package com.study.pattern.factory.simple;

/**
 * 简单工厂 / 静态工厂
 * 如果增加新的子类，需要修改业务代码
 */
public class CarFactory {

    /**
     * 根据类型 返回 具体的车
     * 缺点：违反了开闭原则
     *
     * @param type
     * @return
     */
    public static Car createCar(String type) {
        if ("audi".equals(type)) {
            return new Audi();
        } else if ("byd".equals(type)) {
            return new Byd();
        }
        return null;
    }


}
