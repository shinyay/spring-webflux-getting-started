package io.spring.reactive

import io.spring.reactive.service.CustomerService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	System.setProperty("spring.profiles.active", "prod")
	runApplication<DemoApplication>(*args)
}

@Profile("dev")
@Component
class DemoListener(val customerService: CustomerService) {

	fun exercise() {
		Demo.work(customerService)
    }
}
