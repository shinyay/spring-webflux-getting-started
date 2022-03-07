package io.spring.reactive.service

import io.spring.reactive.entity.Customer
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import java.sql.ResultSet


class BaseCustomerService(
    val jdbcTemplate: JdbcTemplate) : CustomerService {
    val rowMapper = {rs: ResultSet, i: Int ->
        Customer(
            rs.getLong("id"),
            rs.getString("name"))
    }

    override fun save(vararg names: String): Collection<Customer> {
        val customerList = mutableListOf<Customer>()
        for (name in names) {
            val keyHolder = GeneratedKeyHolder()
            jdbcTemplate.update({
                connection ->
                val ps = connection.prepareStatement("insert into CUSTOMERS (name) values (?)")
                ps.setString(1, name)
                ps
            }, keyHolder)
            val keyHolderKey = keyHolder.key?.toLong()
            val customer = this.findById(keyHolderKey!!)
            customerList.add(customer)
        }
        return customerList
    }

    fun findById(id: Long?): Customer? {
        val sql = "select * from CUSTOMERS where id = ?"
        return jdbcTemplate.queryForObject(sql, this.rowMapper, id)
    }

    override fun findAll(): Collection<Customer> {
        TODO("Not yet implemented")
    }
}
