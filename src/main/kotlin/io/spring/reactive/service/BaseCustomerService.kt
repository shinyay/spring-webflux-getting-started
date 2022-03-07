package io.spring.reactive.service

import io.spring.reactive.entity.Customer
import org.springframework.jdbc.core.JdbcTemplate
import java.sql.ResultSet

class BaseCustomerService(
    val jdbcTemplate: JdbcTemplate) : CustomerService {
    val rorMapper = {rs: ResultSet, i: Int ->
        Customer(
            rs.getLong("id"),
            rs.getString("name"))
    }

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
