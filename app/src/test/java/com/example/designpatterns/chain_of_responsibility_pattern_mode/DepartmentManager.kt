package com.example.designpatterns.chain_of_responsibility_pattern_mode
//部门经理
class DepartmentManager(override var name: String, override var couldHandleCount: Int) :
    Leader(name, couldHandleCount) {
}