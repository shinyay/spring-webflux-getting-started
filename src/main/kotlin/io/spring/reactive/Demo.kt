package io.spring.reactive

import io.spring.reactive.service.CustomerService

class Demo {

    fun work(customerService: CustomerService) {
        customerService.findAll()
    }
}
