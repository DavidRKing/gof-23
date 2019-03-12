package com.study.pattern.prototype;

import java.io.*;
import java.util.Date;

/**
 * 原型模式(浅克隆)：
 * 克隆绵羊
 */
public class Sheep implements Cloneable, Serializable {
    private String name;
    private Date birthday;

    public Sheep(String name, Date birthday) {
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
        //直接调用object对象的clone方法
        Object object = super.clone();
        return object;
    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Sheep s1 = new Sheep("douli", new Date());
        System.out.println(s1 + " " + s1.getName() + " " + s1.getBirthday());

        Sheep s2 = (Sheep) s1.clone();
        System.out.println(s2 + " " + s2.getName() + " " + s2.getBirthday());
        //s1与s2公用同一个 date 此时 如果修改s1的date s2也会被修改(浅拷贝)
        System.out.println(s1.getBirthday() == s2.getBirthday());


        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        byte[] bytes = bos.toByteArray();
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Sheep s3 = (Sheep) ois.readObject();


        System.out.println(s1.getBirthday() + " " + s3.getBirthday());

    }


}
