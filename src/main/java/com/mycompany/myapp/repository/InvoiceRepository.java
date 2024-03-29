package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Invoice;
import com.mycompany.myapp.domain.Product;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Spring Data JPA repository for the Invoice entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

    @Query("select distinct invoice from Invoice invoice left join fetch invoice.products")
    List<Invoice> findAllWithEagerRelationships();

    @Query("select invoice from Invoice invoice left join fetch invoice.products where invoice.id =:id")
    Invoice findOneWithEagerRelationships(@Param("id") Long id);

    List<Invoice> findAllByProducts(Product product);
}
