package com.study.pattern.prototype;

import java.util.Date;

/**
 * 原型模式(深克隆)：
 *
 * 通过new产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式.
 *
 * 开发中的应用场景
 * 原型模式一般很少单独出现，一般是和工厂方法模式一起出现，通过clone的方法
 * 创建一个对象，然后由工厂方法提供给调用者。
 *
 * spring中bean的创建实际就是两种：单例模式和原型模式。（当然，原型模式需要和工厂模式
 * 搭配起来。）
 *
 * 或者使用序列化与反序列化 来实现 深克隆
 * 克隆绵羊
 */
public class DeepSheep implements Cloneable {
    private String name;
    private Date birthday;

    public DeepSheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //通过如下形式，实现深拷贝
        Object object = super.clone();
        DeepSheep s = (DeepSheep) object;
        s.birthday = (Date) this.birthday.clone();
        return object;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        DeepSheep s1 = new DeepSheep("douli", new Date());
        System.out.println(s1 + " " + s1.getName() + " " + s1.getBirthday());

        DeepSheep s2 = (DeepSheep) s1.clone();
        System.out.println(s2 + " " + s2.getName() + " " + s2.getBirthday());
        //s1 s2 不公用同一个 date 深拷贝
        System.out.println(s1.getBirthday() == s2.getBirthday());


    }


}
