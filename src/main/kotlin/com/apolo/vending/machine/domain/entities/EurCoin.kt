package com.apolo.vending.machine.domain.entities

import com.apolo.vending.machine.domain.entities.issues.NotValidCoin
import com.github.salomonbrys.kotson.double
import com.google.gson.JsonObject

class EurCoin(json: JsonObject) : Entity(json), Coin {

    private val value: Double = json["value"].double
    private val type: String = "eur"

    init {
        this.json.addProperty("type", this.type)
        validateValue(value.toString())
    }

    private fun validateValue(value: String) {
        val validCoins = listOf("0.05", "0.1", "0.2", "0.5", "1.0", "2.0")

        if (!validCoins.contains(value)) {
            throw NotValidCoin("Error: not valid coin", 501)
        }
    }

    override fun getValue(): Double {
        return this.value
    }

    override fun getType(): String {
        return this.type
    }

}
