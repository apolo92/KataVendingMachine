package com.apolo.vending.machine.domain.services

import com.apolo.vending.machine.domain.entities.Coin
import com.apolo.vending.machine.domain.entities.EurCoin
import com.apolo.vending.machine.domain.entities.Product
import com.apolo.vending.machine.domain.repository.Repository
import com.apolo.vending.machine.domain.services.issues.SalaryInsuficient
import com.apolo.vending.machine.infraestructure.repository.CoinRepository
import com.apolo.vending.machine.infraestructure.repository.PurchasesRepository
import com.github.salomonbrys.kotson.jsonObject
import org.junit.Test
import kotlin.test.assertEquals

class BuyProductTest {

    @Test(expected = SalaryInsuficient::class)
    fun buyOneProductButInsuficientSalary() {
        val productRepo = StubProductRepo()
        BuyProduct.execute("cola", "test", productRepo, CoinRepository, PurchasesRepository)
    }


    @Test
    fun buyOneProductAndReturnThen() {
        val productRepo = StubProductRepo()
        val coinRepo = StubCoinRepo()
        val change = BuyProduct.execute("cola", "test", productRepo, coinRepo, PurchasesRepository)

        assertEquals(change.product().name(), "cola")
        assertEquals(change.product().price(), 2.3)
        assertEquals(change.coins().sumByDouble { coin -> coin.getValue() }, 0.2)
        assertEquals(change.coins().first().getType(), "eur")
    }
}

class StubCoinRepo : Repository<Coin> {
    override fun find(id: String): List<Coin> {
        val jsonCoin1 = jsonObject(
                "value" to 2
        )
        val coin1 = EurCoin(jsonCoin1)

        val jsonCoin2 = jsonObject(
                "value" to 0.5
        )
        val coin2 = EurCoin(jsonCoin2)
        return listOf(coin1, coin2)
    }

    override fun save(id: String, entity: Coin) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class StubProductRepo : Repository<Product> {


    override fun find(id: String): List<Product> {
        val jsonProduct = jsonObject(
                "name" to "cola",
                "price" to 2.3
        )

        val product = Product(jsonProduct)
        return listOf(product)
    }

    override fun save(id: String, entity: Product) {
    }

}
