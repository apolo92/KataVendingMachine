package com.apolo.vending.machine.infraestructure.repository

import com.apolo.vending.machine.domain.entities.Coin
import com.apolo.vending.machine.domain.repository.Repository

object CoinRepository: Repository<Coin> {

    private val coinStore: MutableMap<String, MutableList<Coin>> = HashMap()

    override fun save(userId: String, coin: Coin) {
        val coins = coinStore.getOrDefault(userId, mutableListOf())
        coins.add(coin)
        coinStore.put(userId, coins)
    }

    override fun find(userId: String): List<Coin>{
        return coinStore.getOrDefault(userId, mutableListOf()).toList()
    }

}