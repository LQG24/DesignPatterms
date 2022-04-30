package com.example.designpatterns.chain_of_responsibility_pattern_mode

import org.junit.Test

/**
 * 我们来模拟一个公司的请假流程，比如说，在公司中，我们平时请假，
 * 在 OA 上面发起申请流程，少于 3 天的一般由组长审批即可，
 * 大于 3 天的小于 7 天的由部门总经理审批，大于七天的由公司总经理审批。
 * 这个时候，我们可以考虑用责任链模式来设计。
 */
class ClientTest {
    @Test
    fun test() {
        val teamLeader = TeamLeader("主管", 3)
        val departmentManager = DepartmentManager("部门经理", 7)
        val generalManager = GeneralManager("部门总经理", Int.MAX_VALUE)

        teamLeader.setNextExecutor(departmentManager)
        departmentManager.setNextExecutor(generalManager)

        //请假三天
        val result = teamLeader.handleRequest(3)

        // 请假六天
//        val result = teamLeader.handleRequest(6)
        //// 请假10天

//       val result = teamLeader.handleRequest(10)
        System.out.println("result:$result")
    }
}