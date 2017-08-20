package com.apolo.vending.machine.domain.entities

interface Coin {

    fun getValue(): Double

    fun getType(): String
}