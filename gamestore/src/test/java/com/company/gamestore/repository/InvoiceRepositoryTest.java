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
    public void shouldAddInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Cody");
        invoice.setStreet("116th Avenue");
        invoice.setCity("Forest Hills");
        invoice.setState("New York");
        invoice.setZipcode("11375");
        invoice.setItem_type("Console");
        invoice.setItem_id(45);
        invoice.setUnit_price(new BigDecimal("499.99"));
        invoice.setQuantity(700);
        invoice.setSubtotal(new BigDecimal("745.98"));
        invoice.setTax(new BigDecimal("0.50"));
        invoice.setProcessing_fee(new BigDecimal("4.99"));
        invoice.setTotal(new BigDecimal("750.00"));

        invoice = invoiceRepository.save(invoice);

        //Assert...
        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getId());

        assertEquals(invoice1.get(), invoice);

    }

    @Test
    public void shouldGetAllInvoice() {

        Invoice invoice = new Invoice();
        invoice.setName("Cody");
        invoice.setStreet("116th Avenue");
        invoice.setCity("Forest Hills");
        invoice.setState("New York");
        invoice.setZipcode("11375");
        invoice.setItem_type("Console");
        invoice.setItem_id(45);
        invoice.setUnit_price(new BigDecimal("499.99"));
        invoice.setQuantity(700);
        invoice.setSubtotal(new BigDecimal("745.98"));
        invoice.setTax(new BigDecimal("0.50"));
        invoice.setProcessing_fee(new BigDecimal("4.99"));
        invoice.setTotal(new BigDecimal("750.00"));

        invoiceRepository.save(invoice);

        invoice = new Invoice();
        invoice.setName("Cody");
        invoice.setStreet("116th Avenue");
        invoice.setCity("Forest Hills");
        invoice.setState("New York");
        invoice.setZipcode("11375");
        invoice.setItem_type("Console");
        invoice.setItem_id(45);
        invoice.setUnit_price(new BigDecimal("499.99"));
        invoice.setQuantity(700);
        invoice.setSubtotal(new BigDecimal("745.98"));
        invoice.setTax(new BigDecimal("0.50"));
        invoice.setProcessing_fee(new BigDecimal("4.99"));
        invoice.setTotal(new BigDecimal("750.00"));

        invoiceRepository.save(invoice);
        List<Invoice> invoiceList = invoiceRepository.findAll();

        assertEquals(invoiceList.size(), 2);
    }

//    @Test
//    public void shouldGetGamesByStudio() {
//
//        Game game = new Game();
//        game.setTitle("Portal");
//        game.setEsrb_rating("Rated E");
//        game.setDescription("A game where you make portals to solve puzzles");
//        game.setPrice(new BigDecimal("59.99"));
//        game.setStudio("Bethesda");
//        game.setQuantity(400);
//
//        gameRepository.save(game);
//
//        game = new Game();
//        game.setTitle("Portal");
//        game.setEsrb_rating("Rated E");
//        game.setDescription("A game where you make portals to solve puzzles");
//        game.setPrice(new BigDecimal("59.99"));
//        game.setStudio("Square");
//        game.setQuantity(400);
//
//        gameRepository.save(game);
//
//        game = new Game();
//        game.setTitle("Portal");
//        game.setEsrb_rating("Rated E");
//        game.setDescription("A game where you make portals to solve puzzles");
//        game.setPrice(new BigDecimal("59.99"));
//        game.setStudio("Square");
//        game.setQuantity(300);
//
//        gameRepository.save(game);
//        List<Game> mList = gameRepository.findByStudio("Square");
//
//        assertEquals(2, mList.size());
//
//        mList = gameRepository.findByStudio("Bethesda");
//
//        assertEquals(1, mList.size());
//
//        mList = gameRepository.findByStudio("Epic Games");
//
//        assertEquals(0, mList.size());
//    }

    @Test
    public void shouldGetInvoiceByCustomerName() {

        Invoice invoice = new Invoice();
        invoice.setName("Cody");
        invoice.setStreet("116th Avenue");
        invoice.setCity("Forest Hills");
        invoice.setState("New York");
        invoice.setZipcode("11375");
        invoice.setItem_type("Console");
        invoice.setItem_id(45);
        invoice.setUnit_price(new BigDecimal("499.99"));
        invoice.setQuantity(700);
        invoice.setSubtotal(new BigDecimal("745.98"));
        invoice.setTax(new BigDecimal("0.50"));
        invoice.setProcessing_fee(new BigDecimal("4.99"));
        invoice.setTotal(new BigDecimal("750.00"));

        invoiceRepository.save(invoice);

        invoice = new Invoice();
        invoice.setName("Cody");
        invoice.setStreet("116th Avenue");
        invoice.setCity("Forest Hills");
        invoice.setState("New York");
        invoice.setZipcode("11375");
        invoice.setItem_type("Console");
        invoice.setItem_id(45);
        invoice.setUnit_price(new BigDecimal("499.99"));
        invoice.setQuantity(700);
        invoice.setSubtotal(new BigDecimal("745.98"));
        invoice.setTax(new BigDecimal("0.50"));
        invoice.setProcessing_fee(new BigDecimal("4.99"));
        invoice.setTotal(new BigDecimal("750.00"));

        invoiceRepository.save(invoice);

        Invoice mList = invoiceRepository.findByCustomerName("Cody");

        assertEquals(2, mList.size());

        mList = invoiceRepository.findByCustomerName("David");

        assertEquals(0, mList.size());



    }




}