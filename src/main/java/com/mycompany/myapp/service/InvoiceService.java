package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Invoice;
import com.mycompany.myapp.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Service Interface for managing Product.
 */
public interface InvoiceService {

    /**
     * Save a invoice.
     *
     * @param invoice the entity to save
     * @return the persisted entity
     */
    Invoice save(Invoice invoice);

    /**
     *  Get all the invoices.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<Invoice> findAll(Pageable pageable);

    /**
     *  Get the "id" invoice.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Invoice findOne(Long id);

    /**
     *  Delete the "id" invoice.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    List<Invoice> findAllByProduct(Product product);
}
