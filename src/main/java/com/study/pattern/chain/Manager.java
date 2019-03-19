package com.study.pattern.chain;

/**
 * 经理
 */
public class Manager extends Leader {

    public Manager(String name) {
        super(name);
    }

    public Manager(String name, Leader nextLeader) {
        super(name, nextLeader);
    }

    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() >= 3 && request.getLeaveDays() < 10) {
            System.out.println("经理审批通过: 员工:" + request.getEmpName() + " " + request.getLeaveDays() + "  " + request.getReason());
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
