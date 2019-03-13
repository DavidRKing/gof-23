package com.study.pattern.proxy.staticproxy;

/**
 * 静态代理模式
 * <p>
 * 客户--->经纪人---->歌星
 */
public class Client {

    public static void main(String[] args) {
        Star real = new RealStar();
        Star proxy = new ProxyStar(real);
        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();
        proxy.collectMoney();
    }
}
