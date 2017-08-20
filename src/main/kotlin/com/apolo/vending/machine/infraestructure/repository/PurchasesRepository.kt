package com.apolo.vending.machine.infraestructure.repository

import com.apolo.vending.machine.domain.entities.Product
import com.apolo.vending.machine.domain.repository.Repository

object PurchasesRepository: Repository<Product> {

    private val purchases: MutableMap<String, MutableList<Product>> = HashMap()

    override fun save(userId: String, product: Product){
        val products = this.purchases.getOrDefault(userId, mutableListOf())
        products.add(product)
        this.purchases.put(userId, products)
    }

    override fun find(userId: String): List<Product> {
        return this.purchases.getOrDefault(userId, mutableListOf()).toList()
    }
}