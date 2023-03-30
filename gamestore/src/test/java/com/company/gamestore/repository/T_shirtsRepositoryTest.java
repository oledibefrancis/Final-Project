package com.company.gamestore.repository;

import com.company.gamestore.model.Game;
import com.company.gamestore.model.T_Shirt;
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
public class T_shirtsRepositoryTest {

    @Autowired
    T_shirtsRepository t_shirtsRepository;

    @Before
    public void setUp() {
        t_shirtsRepository.deleteAll();
    }

    @Test
    public void shouldAddAndGetT_Shirt() {
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Red");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        t_shirt = t_shirtsRepository.save(t_shirt);

        Optional<T_Shirt> t_shirt1 = t_shirtsRepository.findById(t_shirt.getId());

        assertEquals(t_shirt1.get(),t_shirt);

    }

    @Test
    public void shouldGetAllT_Shirts() {

        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Red");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        t_shirtsRepository.save(t_shirt);

        t_shirt = new T_Shirt();
        t_shirt.setSize("Large");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("The TShirt fits big");
        t_shirt.setPrice(new BigDecimal("10.99"));
        t_shirt.setQuantity(700);

        t_shirtsRepository.save(t_shirt);
        List<T_Shirt> t_shirtList = t_shirtsRepository.findAll();

        assertEquals(2, t_shirtList.size());
    }

    @Test
    public void shouldUpdateT_Shirt() {

        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Red");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        t_shirt = t_shirtsRepository.save(t_shirt);

        t_shirt.setSize("Large");

        t_shirtsRepository.save(t_shirt);

        Optional<T_Shirt> t_shirt1 = t_shirtsRepository.findById(t_shirt.getId());

        assertEquals(t_shirt1.get(), t_shirt);

    }

    @Test
    public void shouldGetT_ShirtsByColor() {

        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Red");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        t_shirtsRepository.save(t_shirt);

        t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Yellow");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

       t_shirtsRepository.save(t_shirt);

        t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Yellow");
        t_shirt.setDescription("The TShirt is in limited quantity");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(40);

        t_shirtsRepository.save(t_shirt);
        List<T_Shirt> mList = t_shirtsRepository.findByColor("Yellow");

        assertEquals(2, mList.size());

        mList = t_shirtsRepository.findByColor("Red");

        assertEquals(1, mList.size());

        mList = t_shirtsRepository.findByColor("Green");

        assertEquals(0, mList.size());
    }
    @Test
    public void shouldGetT_ShirtsBySize() {

        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Red");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        t_shirtsRepository.save(t_shirt);

        t_shirt = new T_Shirt();
        t_shirt.setSize("Large");
        t_shirt.setColor("Red");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        t_shirtsRepository.save(t_shirt);

        t_shirt = new T_Shirt();
        t_shirt.setSize("Large");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        t_shirtsRepository.save(t_shirt);
        List<T_Shirt> mList = t_shirtsRepository.findBySize("Large");

        assertEquals(2, mList.size());

        mList = t_shirtsRepository.findBySize("Medium");

        assertEquals(1, mList.size());

        mList = t_shirtsRepository.findBySize("Small");

        assertEquals(0, mList.size());
    }
    @Test
    public void shouldDeleteT_Shirt() {

        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Red");
        t_shirt.setDescription("The TShirt is true to size");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(500);

        t_shirt = t_shirtsRepository.save(t_shirt);

        //ACT
        t_shirtsRepository.deleteById(t_shirt.getId());

        //Assert...
        Optional<T_Shirt> t_shirt1 = t_shirtsRepository.findById(t_shirt.getId());
        assertFalse(t_shirt1.isPresent());

    }


}