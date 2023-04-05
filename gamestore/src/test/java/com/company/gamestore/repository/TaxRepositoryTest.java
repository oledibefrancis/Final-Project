package com.company.gamestore.repository;

import com.company.gamestore.model.Tax;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaxRepositoryTest {
    @Autowired
    TaxRepository taxRepository;

    Tax tax1;
    Tax tax2;

    @Before
    public void setUp() throws Exception {

            taxRepository.deleteAll();

            tax1 = new Tax();
            tax1.setState("AR");
            tax1.setRate(BigDecimal.valueOf(90.09));
            taxRepository.save(tax1);

            tax2 = new Tax();
            tax2.setState("CA");
            tax2.setRate(BigDecimal.valueOf(.09));
            taxRepository.save(tax2);

    }
    // Test Post
    @Test
    public void testCreateTax() {
        Tax newTax = new Tax();
        newTax.setState("MA");
        newTax.setRate(BigDecimal.valueOf(.07));
        taxRepository.save(newTax);

        assertEquals(3, taxRepository.findAll().size());
    }

    // Test Update
    @Test
    public void testUpdateTax() {
        tax1.setRate(BigDecimal.valueOf(.05));
        taxRepository.save(tax1);

        Optional<Tax> taxFromRepo = taxRepository.findById(tax1.getState());
        BigDecimal rate = taxFromRepo.get().getRate();
        assertEquals(tax1.getRate(), rate.stripTrailingZeros());
    }

    // Test Get all
    @Test
    public void testGetAllTaxes() {
        assertEquals(2, taxRepository.findAll().size());
    }

    // Test Get by ID
    @Test
    public void testGetTaxById() {
        Optional<Tax> taxFromRepo = taxRepository.findById(tax1.getState());
        BigDecimal rate = taxFromRepo.get().getRate().stripTrailingZeros();
        assertEquals(rate, tax1.getRate());
    }

    // Test Delete
    // Test Get by ID
    @Test
    public void testDeleteTax() {
        taxRepository.deleteById(tax1.getState());
        Optional<Tax> taxFromRepo = taxRepository.findById(tax1.getState());
        assertFalse(taxFromRepo.isPresent());
    }

}