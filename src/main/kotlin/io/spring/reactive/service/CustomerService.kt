package io.spring.reactive.service

import io.spring.reactive.entity.Customer

interface CustomerService {
    fun save(vararg names: String): Collection<Customer>
    fun findById(id: Long): Customer
    fun findAll(): Collection<Customer>
}
