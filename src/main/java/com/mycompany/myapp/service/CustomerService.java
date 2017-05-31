package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Customer;
import com.mycompany.myapp.domain.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Product.
 */
public interface CustomerService {

    /**
     * Save a customer.
     *
     * @param customer the entity to save
     * @return the persisted entity
     */
    Customer save(Customer customer);

    /**
     *  Get all the customers.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<Customer> findAll(Pageable pageable);

    /**
     *  Get the "id" customer.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Customer findOne(Long id);

    /**
     *  Delete the "id" customer.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    public Customer findOneByInvoice(Invoice invoice);
}
