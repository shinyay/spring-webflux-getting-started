package io.spring.reactive.service

import io.spring.reactive.entity.Customer
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.sql.DataSource


@Service
@Transactional
class TransactionalCustomerService(val ds: DataSource) : BaseCustomerService(ds) {

    override fun save(vararg names: String): Collection<Customer> {
        return super.save(*names)
    }

    fun findById(id: Long?): Customer? {
        return super.findById(id!!)
    }

    override fun findAll(): MutableList<Customer>? {
        return super.findAll()
    }
}
