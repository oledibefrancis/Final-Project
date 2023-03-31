package com.company.gamestore.repository;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleRepositoryTest {

    @Autowired
    ConsoleRepository consoleRepository;


    @Before
    public void setUp() {
        consoleRepository.deleteAll();
    }


    @Test
    public void shouldAddAndGetConsoles() {

        Console console = new Console();
        console.setModel("2020");
        console.setManufacturer("Playstation");
        console.setMemory_amount("2TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("799.99"));
        console.setQuantity(150);

        console = consoleRepository.save(console);

        Optional<Console> console1 = consoleRepository.findById(console.getId());

        assertEquals(console1.get(), console);

    }

    @Test
    public void shouldGetAllConsoles() {

        Console console = new Console();
        console.setModel("2020");
        console.setManufacturer("Playstation");
        console.setMemory_amount("2TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("799.99"));
        console.setQuantity(150);

        consoleRepository.save(console);

        console = new Console();
        console.setModel("2018");
        console.setManufacturer("Nintendo");
        console.setMemory_amount("1GB");
        console.setProcessor("OkayProcessor");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(240);

        consoleRepository.save(console);
        List<Console> consoleList = consoleRepository.findAll();

        assertEquals(2, consoleList.size());
    }

    @Test
    public void shouldUpdateConsole() {
        Console console = new Console();
        console.setModel("2020");
        console.setManufacturer("Playstation");
        console.setMemory_amount("2TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("799.99"));
        console.setQuantity(150);

        console = consoleRepository.save(console);

        console.setModel("2021");

        console = consoleRepository.save(console);

        Optional<Console> console1 = consoleRepository.findById(console.getId());

        assertEquals(console1.get(), console);
    }

    @Test
    public void shouldDeleteConsole() {
        Console console = new Console();
        console.setModel("2020");
        console.setManufacturer("Playstation");
        console.setMemory_amount("2TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("799.99"));
        console.setQuantity(150);


        consoleRepository.save(console);

        consoleRepository.deleteById(console.getId());

        Optional<Console> console1 = consoleRepository.findById(console.getId());
        assertFalse(console1.isPresent());

    }

    @Test
    public void shouldGetConsolesByManufacturer() {

        Console console = new Console();
        console.setModel("2020");
        console.setManufacturer("Playstation");
        console.setMemory_amount("2TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("799.99"));
        console.setQuantity(150);

        consoleRepository.save(console);

        console = new Console();
        console.setModel("2019");
        console.setManufacturer("Amazon");
        console.setMemory_amount("1TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("399.99"));
        console.setQuantity(150);

        consoleRepository.save(console);

        console = new Console();
        console.setModel("2019");
        console.setManufacturer("Amazon");
        console.setMemory_amount("1TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("399.99"));
        console.setQuantity(150);

        consoleRepository.save(console);
        List<Console> mList = consoleRepository.findByManufacturer("Amazon");

        assertEquals(2, mList.size());

        mList = consoleRepository.findByManufacturer("Playstation");

        assertEquals(1, mList.size());

        mList = consoleRepository.findByManufacturer("Microsoft");

        assertEquals(0, mList.size());
    }
}
