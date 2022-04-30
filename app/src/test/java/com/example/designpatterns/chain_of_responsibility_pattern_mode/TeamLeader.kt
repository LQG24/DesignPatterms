package com.example.designpatterns.chain_of_responsibility_pattern_mode
//团队领导
class TeamLeader(override var name: String, override var couldHandleCount: Int):Leader(name,couldHandleCount) {
}