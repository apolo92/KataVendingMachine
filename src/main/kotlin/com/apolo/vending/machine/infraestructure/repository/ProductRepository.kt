package com.apolo.vending.machine.infraestructure.repository

import com.apolo.vending.machine.domain.entities.Product
import com.apolo.vending.machine.domain.repository.Repository

object ProductRepository : Repository<Product> {

    private val allProducts: MutableMap<String, MutableList<Product>> = HashMap()

    override fun save(id: String, entity: Product) {
        val products = this.allProducts.getOrDefault(id, mutableListOf())
        products.add(entity)
        this.allProducts.put(id, products)
    }

    override fun find(productName: String): List<Product> {
        return this.allProducts.getOrDefault(productName, mutableListOf()).toList()
    }
}