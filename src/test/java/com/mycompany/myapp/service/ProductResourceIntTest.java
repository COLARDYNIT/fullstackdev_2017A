package com.mycompany.myapp.service;

import com.mycompany.myapp.Fullstackdev2017AApp;
import com.mycompany.myapp.domain.Customer;
import com.mycompany.myapp.domain.Invoice;
import com.mycompany.myapp.domain.Product;
import com.mycompany.myapp.repository.CustomerRepository;
import com.mycompany.myapp.repository.InvoiceRepository;
import com.mycompany.myapp.repository.ProductRepository;
import com.mycompany.myapp.web.rest.ProductResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by stijnhaesendonck on 31/05/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Fullstackdev2017AApp.class)
@Transactional
public class ProductResourceIntTest {
    @Resource
    ProductRepository productRepository;
    @Resource
    CustomerRepository customerRepository;
    @Resource
    InvoiceRepository invoiceRepository;

    @Resource
    ProductResource productResource;

    String appleName = "apple";

    @Before
    public void setUp() {
        productRepository.deleteAll();
        customerRepository.deleteAll();
        productRepository.deleteAll();

        Product apple = new Product();
        Product pear = new Product();
        apple.setName(appleName);
        pear.setName("pear");

        productRepository.save(apple);
        productRepository.save(pear);

        Customer marcel = new Customer();
        Customer fons = new Customer();
        marcel.setName("Marcel");
        fons.setName("Fons");

        customerRepository.save(marcel);
        customerRepository.save(fons);

        Invoice appleMarcel = new Invoice();
        appleMarcel.setCustomer(marcel);
        appleMarcel.addProduct(apple);

        Invoice applePearFons = new Invoice();
        applePearFons.setCustomer(fons);
        applePearFons.addProduct(apple);
        applePearFons.addProduct(pear);

        Invoice appleFons = new Invoice();
        appleFons.setCustomer(fons);
        appleFons.addProduct(apple);

        invoiceRepository.save(appleMarcel);
        invoiceRepository.save(applePearFons);
        invoiceRepository.save(appleFons);

    }

    @Test
    public void testFindCustomersForProduct() {
        List<Customer> customersForProduct = productResource.findCustomersForProduct(appleName);

        assertTrue(customersForProduct.size() == 2);
    }
}
