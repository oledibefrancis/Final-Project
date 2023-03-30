package com.company.gamestore.repository;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceRepositoryTest {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    T_shirtsRepository t_shirtsRepository;

    @Before
    public void setUp() {
        gameRepository.deleteAll();
        invoiceRepository.deleteAll();
        t_shirtsRepository.deleteAll();
    }

//    @Test
//    public void addInvoice() {
//        Invoice invoice = new Invoice();
//        invoice.setName("Cody");
//        invoice.setStreet("116th Avenue");
//        invoice.setCity("Forest Hills");
//        invoice.setState("New York");
//        invoice.setZipcode("11375");
//        invoice.setItem_type("Console");
//        invoice.setItem_id(45);
//        invoice.setUnit_price(new BigDecimal("499.99"));
//        invoice.setQuantity(700);
//        invoice.setSubtotal(new BigDecimal("745.98"));
//        invoice.setTax(new BigDecimal("0.50"));
//        invoice.setProcessing_fee(new BigDecimal("4.99"));
//        invoice.setTotal(new BigDecimal("750.00"));
//
//    }

}