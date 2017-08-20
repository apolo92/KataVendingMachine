package com.apolo.vending.machine.domain.entities.issues

class NotValidCoin : RuntimeException {
    private val code: Int

    constructor(message: String, code: Int) : super(message) {
        println(message)
        this.code = code;
    }

    fun getCodeError(): Int{
        return this.code;
    }
}