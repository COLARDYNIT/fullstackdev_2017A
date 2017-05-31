package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Customer;
import com.mycompany.myapp.domain.Invoice;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Customer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findOneByInvoices(Invoice invoice);
}
