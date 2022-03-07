package io.spring.reactive.service

import io.spring.reactive.entity.Customer

class BaseCustomerService : CustomerService {
    override fun save(names: String): Collection<Customer> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Customer {
        TODO("Not yet implemented")
    }

    override fun findAll(): Collection<Customer> {
        TODO("Not yet implemented")
    }
}
