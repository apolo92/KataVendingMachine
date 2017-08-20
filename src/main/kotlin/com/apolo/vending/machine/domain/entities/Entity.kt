package com.apolo.vending.machine.domain.entities

import com.github.salomonbrys.kotson.deepCopy
import com.google.gson.JsonObject

open class Entity (json: JsonObject) {
    protected val json: JsonObject = json

    fun entityJson(): JsonObject{
        return this.json.deepCopy()
    }
}