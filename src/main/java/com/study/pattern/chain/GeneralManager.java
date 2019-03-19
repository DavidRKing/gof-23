package com.study.pattern.chain;

/**
 * 总经理
 */
public class GeneralManager extends Leader {


    public GeneralManager(String name) {
        super(name);
    }

    public GeneralManager(String name, Leader nextLeader) {
        super(name, nextLeader);
    }

    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() >= 10 && request.getLeaveDays() < 30) {
            System.out.println("总经理审批通过: 员工:" + request.getEmpName() + " " + request.getLeaveDays() + "  " + request.getReason());
        } else {
            System.out.println("请假时间过长，无法处理");
        }
    }
}
