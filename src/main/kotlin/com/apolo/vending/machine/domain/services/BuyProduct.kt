package com.apolo.vending.machine.domain.services

import com.apolo.vending.machine.domain.entities.Coin
import com.apolo.vending.machine.domain.entities.Product
import com.apolo.vending.machine.domain.repository.Repository
import com.apolo.vending.machine.domain.services.issues.SalaryInsuficient
import com.apolo.vending.machine.domain.valueObject.ChangeProductAndCoins

object BuyProduct {

    fun execute(productName: String, userId: String, productRepo: Repository<Product>, coinRepo: Repository<Coin>, purchasesRepo: Repository<Product>): ChangeProductAndCoins {
        val product = productRepo.find(productName)[0]
        val coins = coinRepo.find(userId)

        val salary = coins.sumByDouble { coin -> coin.getValue() }

        if (salary < product.price()) {
            throw SalaryInsuficient("No tienes salario disponible: " + salary + " precio: " + product.price(), 502)
        }

        purchasesRepo.save(userId, product)

        return ChangeProductAndCoins(salary, product)
    }

}