package com.company.gamestore.repository;

import com.company.gamestore.model.Game;
import com.company.gamestore.model.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceRepositoryTest {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Before
    public void setUp() {

        invoiceRepository.deleteAll();
    }

    @Test
    public void shouldAddAndGetInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("David");
        invoice.setStreet("100 winchester Circle");
        invoice.setCity("Los Gatos");
        invoice.setState("CA");
        invoice.setZipcode("95032");
        invoice.setItem_type("Console");
        invoice.setItem_id(25);
        invoice.setUnit_price(new BigDecimal("399.99"));
        invoice.setQuantity(50);
        invoice.setSubtotal(new BigDecimal("500.00"));
        invoice.setTax(new BigDecimal("1.50"));
        invoice.setProcessing_fee(new BigDecimal("6.99"));
        invoice.setTotal(new BigDecimal("550.00"));

        invoice = invoiceRepository.save(invoice);

        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getId());

        assertEquals(invoice1.get(), invoice);

    }

    @Test
    public void shouldGetAllInvoice() {

        Invoice invoice = new Invoice();
        invoice.setName("David");
        invoice.setStreet("100 winchester Circle");
        invoice.setCity("Los Gatos");
        invoice.setState("CA");
        invoice.setZipcode("95032");
        invoice.setItem_type("Console");
        invoice.setItem_id(25);
        invoice.setUnit_price(new BigDecimal("399.99"));
        invoice.setQuantity(50);
        invoice.setSubtotal(new BigDecimal("500.00"));
        invoice.setTax(new BigDecimal("1.50"));
        invoice.setProcessing_fee(new BigDecimal("6.99"));
        invoice.setTotal(new BigDecimal("550.00"));

        invoiceRepository.save(invoice);

        invoice = new Invoice();
        invoice.setName("David");
        invoice.setStreet("100 winchester Circle");
        invoice.setCity("Los Gatos");
        invoice.setState("CA");
        invoice.setZipcode("95032");
        invoice.setItem_type("Console");
        invoice.setItem_id(25);
        invoice.setUnit_price(new BigDecimal("399.99"));
        invoice.setQuantity(50);
        invoice.setSubtotal(new BigDecimal("500.00"));
        invoice.setTax(new BigDecimal("1.50"));
        invoice.setProcessing_fee(new BigDecimal("6.99"));
        invoice.setTotal(new BigDecimal("550.00"));

        invoiceRepository.save(invoice);
        List<Invoice> invoiceList = invoiceRepository.findAll();

        assertEquals(invoiceList.size(), 2);
    }

    @Test
    public void shouldGetInvoiceByCustomerName() {

        Invoice invoice = new Invoice();
        invoice.setName("David");
        invoice.setStreet("100 winchester Circle");
        invoice.setCity("Los Gatos");
        invoice.setState("CA");
        invoice.setZipcode("95032");
        invoice.setItem_type("Console");
        invoice.setItem_id(25);
        invoice.setUnit_price(new BigDecimal("399.99"));
        invoice.setQuantity(50);
        invoice.setSubtotal(new BigDecimal("500.00"));
        invoice.setTax(new BigDecimal("1.50"));
        invoice.setProcessing_fee(new BigDecimal("6.99"));
        invoice.setTotal(new BigDecimal("550.00"));
        invoiceRepository.save(invoice);

        invoice = new Invoice();
        invoice.setName("David");
        invoice.setStreet("100 winchester Circle");
        invoice.setCity("Los Gatos");
        invoice.setState("CA");
        invoice.setZipcode("95032");
        invoice.setItem_type("Console");
        invoice.setItem_id(25);
        invoice.setUnit_price(new BigDecimal("399.99"));
        invoice.setQuantity(50);
        invoice.setSubtotal(new BigDecimal("500.00"));
        invoice.setTax(new BigDecimal("1.50"));
        invoice.setProcessing_fee(new BigDecimal("6.99"));
        invoice.setTotal(new BigDecimal("550.00"));


        invoiceRepository.save(invoice);

        Invoice invoice1 = invoiceRepository.findByName("David");

        assertEquals(invoice1.getName(), invoice);

    }

}