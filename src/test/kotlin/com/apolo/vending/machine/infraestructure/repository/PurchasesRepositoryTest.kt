package com.apolo.vending.machine.infraestructure.repository

import com.apolo.vending.machine.domain.entities.Product
import com.github.salomonbrys.kotson.jsonObject
import org.junit.Test
import kotlin.test.assertEquals

class PurchasesRepositoryTest {

    @Test
    fun saveOnePurchaseAndRecoveryAllPurchaseByUser() {
        val jsonProduct = jsonObject(
                "name" to "cola",
                "price" to 2.3
        )
        val product = Product(jsonProduct)
        PurchasesRepository.save("test", product)

        val purchases = PurchasesRepository.find("test")
        assertEquals(purchases[0].name(), product.name())
        assertEquals(purchases[0].price(), product.price())
    }
}