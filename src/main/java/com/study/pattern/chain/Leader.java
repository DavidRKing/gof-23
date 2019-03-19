package com.study.pattern.chain;

/**
 * 抽象类， leader
 */
public abstract class Leader {
    protected String name;
    protected Leader nextLeader;//责任链的后继对象

    public Leader(String name) {
        this.name = name;
    }

    public Leader(String name, Leader nextLeader) {
        this.name = name;
        this.nextLeader = nextLeader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Leader getNextLeader() {
        return nextLeader;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    /**
     * 处理请求核心业务方法
     *
     * @param request 请假条
     */
    public abstract void handleRequest(LeaveRequest request);
}
