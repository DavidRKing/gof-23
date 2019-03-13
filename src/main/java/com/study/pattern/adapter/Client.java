package com.study.pattern.adapter;

/**
 * 客户端
 * （相当于笔记本电脑,只有USB接口）
 * <p>
 * InputStreamReader(InputStream)
 * OutputStreamWriter(OutputStream)
 */
public class Client {

    public void test(Target t) {
        t.handleRequest();
    }

    public static void main(String[] args) {
        //类继承方式
        Client client = new Client();
        Target target = new Adapter();
        client.test(target);

        //组合方式
        Target target2 = new CombineAdapter(new Adaptee());
        client.test(target2);


    }
}
