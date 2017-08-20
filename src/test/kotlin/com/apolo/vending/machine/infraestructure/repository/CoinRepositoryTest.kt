package com.apolo.vending.machine.infraestructure.repository

import com.apolo.vending.machine.domain.entities.EurCoin
import com.github.salomonbrys.kotson.jsonObject
import org.junit.Test
import kotlin.test.assertEquals

class CoinRepositoryTest {

    @Test
    fun saveOneCoinIntoReposiroty() {
        val jsonCoin = jsonObject(
                "value" to 0.10
        )

        val coin = EurCoin(jsonCoin)
        CoinRepository.save("test", coin)

        var coins = CoinRepository.find("test")
        assertEquals(coins[0].getValue(), coin.getValue())
        assertEquals(coins[0].getType(), coin.getType())
    }

}
