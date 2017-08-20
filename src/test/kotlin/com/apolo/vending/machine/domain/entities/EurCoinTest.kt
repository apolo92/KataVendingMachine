package com.apolo.vending.machine.domain.entities

import com.apolo.vending.machine.domain.entities.issues.NotValidCoin
import com.github.salomonbrys.kotson.jsonObject
import com.google.gson.JsonObject
import org.junit.Test
import kotlin.test.assertEquals

class EurCoinTest {

    @Test(expected = NotValidCoin::class)
    fun createInvalidEurCoin() {
        val json: JsonObject = jsonObject(
                "value" to 0.3
        )

        EurCoin(json)
    }

    @Test
    fun createValidEurCoint() {
        val json: JsonObject = jsonObject(
                "value" to 0.10
        )

        val coin = EurCoin(json)
        assertEquals(coin.getValue(), 0.10)
        assertEquals(coin.getType(), "eur")
    }

}
