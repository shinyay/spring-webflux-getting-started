package io.spring.reactive

import io.spring.reactive.service.CustomerService

class Demo {

    fun work(customerService: CustomerService) {
        customerService.findAll()?.forEach {
            customer -> {
                val customerId = customer.id
                val customerById = customerService.findById(customerId)
            }
        }
    }
}
