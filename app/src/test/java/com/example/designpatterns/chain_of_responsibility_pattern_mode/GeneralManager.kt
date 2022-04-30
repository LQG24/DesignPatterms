package com.example.designpatterns.chain_of_responsibility_pattern_mode

class GeneralManager(override var name: String, override var couldHandleCount: Int) :
    Leader(name, couldHandleCount) {
}