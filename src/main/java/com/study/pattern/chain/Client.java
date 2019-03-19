package com.study.pattern.chain;

/**
 * 责任链模式
 * <p>
 * 责任链的关系可以写到配置文件，通过反射实例化
 * <p>
 * java异常处理,catch不匹配，跳转到下一个catch
 * <p>
 * 过滤器的链式处理
 */
public class Client {
    public static void main(String[] args) {
        Leader a = new Director("张主任");
        Leader b = new Manager("李经理");
        Leader c = new GeneralManager("王总");

        //组织责任链对象关系
        a.setNextLeader(b);
        b.setNextLeader(c);

        //开始审批请假
        LeaveRequest request = new LeaveRequest("Li", 1, "出去玩");
        a.handleRequest(request);
    }
}
