package com.study.pattern.chain;

/**
 * 主任
 */
public class Director extends Leader {


    public Director(String name) {
        super(name);
    }

    public Director(String name, Leader nextLeader) {
        super(name, nextLeader);
    }

    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 3) {
            System.out.println("主任审批通过: 员工:" + request.getEmpName() + " " + request.getLeaveDays() + "  " + request.getReason());
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
