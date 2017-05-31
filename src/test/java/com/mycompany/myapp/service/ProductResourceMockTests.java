package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Customer;
import com.mycompany.myapp.domain.Invoice;
import com.mycompany.myapp.domain.Product;
import com.mycompany.myapp.web.rest.ProductResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doReturn;

/**
 * Created by stijnhaesendonck on 31/05/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductResourceMockTests {
    @Mock
    private ProductService productService;
    @Mock
    private InvoiceService invoiceService;
    @Mock
    private CustomerService customerService;

    @InjectMocks
    private ProductResource productResource;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindCustomersForProduct(){
        Customer customer = new Customer();
        String name = "Marcel";
        customer.setId(1l);
        customer.setName(name);

        Product apple = new Product();
        apple.setId(1l);
        apple.setName("apple");

        List<Invoice> invoices = new ArrayList<>();
        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setId(1l);
        invoices.add(invoice);

        doReturn(apple).when(productService).findOne(anyString());
        doReturn(invoices).when(invoiceService).findAllByProduct(any(Product.class));
        doReturn(customer).when(customerService).findOneByInvoice(any(Invoice.class));


        List<Customer> customersForProduct = productResource.findCustomersForProduct("apple");

        assertTrue(customersForProduct.contains(customer));


    }
}
