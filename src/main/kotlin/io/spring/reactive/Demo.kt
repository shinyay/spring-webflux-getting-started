package io.spring.reactive

import io.spring.reactive.service.CustomerService

class Demo {

    companion object {
        fun work(customerService: CustomerService) {
            customerService.findAll()?.forEach { customer ->
                {
                    val customerId = customer.id
                    val customerById = customerService.findById(customerId)
                    println("Found: $customerById")
                }
            }
        }
    }
}
