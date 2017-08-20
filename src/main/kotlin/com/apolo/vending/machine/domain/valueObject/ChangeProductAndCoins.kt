package com.apolo.vending.machine.domain.valueObject

import com.apolo.vending.machine.domain.entities.Coin
import com.apolo.vending.machine.domain.entities.EurCoin
import com.apolo.vending.machine.domain.entities.Product
import com.github.salomonbrys.kotson.jsonObject

class ChangeProductAndCoins(salary: Double, product: Product) {

    private val product = product
    private val coins: MutableList<Coin> = mutableListOf()

    init {
        var change = salary - product.price()
        val listCoinsOk = listOf(2.0, 1.0, 0.5, 0.2, 0.1, 0.05)
        listCoinsOk.forEach { element ->
            var coinsToCreate = change.div(element)
            while (coinsToCreate >= 1) {
                this.coins.add(EurCoin(jsonObject("value" to element)))
                change -= element
                coinsToCreate --
            }
        }
    }

    fun product(): Product {
        return this.product
    }

    fun coins(): List<Coin> {
        return this.coins
    }
}