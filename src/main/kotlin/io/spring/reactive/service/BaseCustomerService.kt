package io.spring.reactive.service

import io.spring.reactive.entity.Customer
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import java.sql.ResultSet
import javax.sql.DataSource


open class BaseCustomerService(val ds: DataSource) : CustomerService {
    private val rowMapper = { rs: ResultSet, i: Int ->
        Customer(
            rs.getLong("id"),
            rs.getString("name"))
    }

    private val jdbcTemplate: JdbcTemplate? = null

    override fun save(vararg names: String): Collection<Customer> {
        val customerList = mutableListOf<Customer>()
        for (name in names) {
            val keyHolder = GeneratedKeyHolder()
            jdbcTemplate?.update({
                connection ->
                val ps = connection.prepareStatement("insert into CUSTOMERS (name) values (?)")
                ps.setString(1, name)
                ps
            }, keyHolder)
            val keyHolderKey = keyHolder.key?.toLong()
            val customer = this.findById(keyHolderKey!!)
            customerList.add(customer!!)
        }
        return customerList
    }

    override fun findById(id: Long): Customer? {
        val sql = "select * from CUSTOMERS where id = ?"
        return jdbcTemplate?.queryForObject(sql, this.rowMapper, id)
    }

    override fun findAll(): MutableList<Customer>? {
        val sql = "select * from CUSTOMERS"
        return jdbcTemplate?.query(sql, this.rowMapper)
    }
}
