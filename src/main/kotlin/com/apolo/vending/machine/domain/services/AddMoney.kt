package com.apolo.vending.machine.domain.services

import com.apolo.vending.machine.domain.entities.Coin
import com.apolo.vending.machine.domain.repository.Repository

object AddMoney {

    fun execute(coin: Coin, userId: String, repo: Repository<Coin>) {
        repo.save(userId, coin)
    }
}