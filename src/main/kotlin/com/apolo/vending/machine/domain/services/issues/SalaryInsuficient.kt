package com.apolo.vending.machine.domain.services.issues

class SalaryInsuficient : RuntimeException {
    private val code: Int

    constructor(message: String, code: Int) : super(message) {
        println(message)
        this.code = code;
    }

    fun getCodeError(): Int {
        return this.code;
    }

}