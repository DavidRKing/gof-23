package com.study.gc.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Java8及之后的版本使用Metaspace来代替元空间
 * <p>
 * MetaSpace是方法区在Hotspot中的实现，它与持久代最大的区别在于:MetaSpace并不在
 * 虚拟机内存中而是使用本地内存也即在java8中，class metadata(the virtual machines internal presentation of java class),
 * 被存储在叫做metaspace的native memory
 * <p>
 * 永久代(java8后被元空间Metaspace取代了)存放了以下信息：
 * 虚拟机加载的类信息
 * 常量池
 * 静态变量
 * 即使编译后的代码
 * <p>
 * 模拟metaspace空间溢出，我们不断生成类往元空间里灌，类占据的空间总是会超过metaspace指定的空间的大小。
 */
public class MetaspaceOOMTest {

    static class OOMTest {

    }

    public static void main(String[] args) {
        int i = 0;//模拟计数多少次以后，发生异常
        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Exception e) {
            System.out.println("多少次 " + i + " 发生了异常");
            e.printStackTrace();
        }
    }
}
