package io.spring.reactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	System.setProperty("spring.profiles.active", "prod")
	runApplication<DemoApplication>(*args)
}
