package com.apolo.vending.machine.domain.entities

import com.github.salomonbrys.kotson.double
import com.github.salomonbrys.kotson.string
import com.google.gson.JsonObject

class Product {

    private val name: String
    private val price: Double

    constructor(json: JsonObject) {
        this.name = json["name"].string
        this.price = json["price"].double
    }

    fun price(): Double {
        return price
    }

    fun name(): String {
        return name
    }


}