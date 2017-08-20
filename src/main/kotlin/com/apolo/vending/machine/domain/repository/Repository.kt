package com.apolo.vending.machine.domain.repository

interface Repository<T> {

    fun save(id: String, entity: T)

    fun find(id: String): List<T>
}