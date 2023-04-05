package com.company.gamestore.service;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Game;
import com.company.gamestore.model.Invoice;
import com.company.gamestore.model.T_Shirt;
import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.repository.GameRepository;
import com.company.gamestore.repository.InvoiceRepository;
import com.company.gamestore.repository.T_shirtsRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static junit.framework.TestCase.assertEquals;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTests {

    ServiceLayer service;

    ConsoleRepository consoleRepository;

    GameRepository gameRepository;

    InvoiceRepository invoiceRepository;

    T_shirtsRepository t_shirtsRepository;

    @Before
    public void setUp() throws Exception {
        setUpConsoleRepositoryMock();
        setUpGameRepositoryMock();
        setUpInvoiceRepositoryMock();
        setUpT_shirtsRepositoryMock();

        service = new ServiceLayer(consoleRepository, gameRepository, invoiceRepository, t_shirtsRepository);
    }

    @Test
    public void shouldSaveConsole() {
        Console console = new Console();
        console.setId(1);
        console.setModel("2020");
        console.setManufacturer("Playstation");
        console.setMemory_amount("2TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("799.99"));
        console.setQuantity(150);

        Console console2 = new Console();
        console2.setModel("2020");
        console2.setManufacturer("Playstation");
        console2.setMemory_amount("2TB");
        console2.setProcessor("GoodProcessor");
        console2.setPrice(new BigDecimal("799.99"));
        console2.setQuantity(150);

        console2 = service.saveConsole(console2);
        assertEquals(console, console2);
    }

    @Test
    public void shouldFindConsole() {
        Console console = new Console();
        console.setId(1);
        console.setModel("2020");
        console.setManufacturer("Playstation");
        console.setMemory_amount("2TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("799.99"));
        console.setQuantity(150);

        Console console2 = new Console();
        console2.setModel("2020");
        console2.setManufacturer("Playstation");
        console2.setMemory_amount("2TB");
        console2.setProcessor("GoodProcessor");
        console2.setPrice(new BigDecimal("799.99"));
        console2.setQuantity(150);

        console2 = service.saveConsole(console2);
        console2 = service.findConsole(1);
        assertEquals(console, console2);
    }

    @Test
    public void shouldSaveGame() {
        Game game = new Game();
        game.setId(10);
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated E");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Fifa");
        game.setQuantity(40);


        Game game2 = new Game();
        game2.setTitle("Fifa 23");
        game2.setEsrb_rating("Rated E");
        game2.setDescription("For everyone");
        game2.setPrice(new BigDecimal("49.99"));
        game2.setStudio("Fifa");
        game2.setQuantity(40);

        game2 = service.saveGame(game2);
        assertEquals(game, game2);
    }

    @Test
    public void shouldFindGame() {
        Game game = new Game();
        game.setId(10);
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated E");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Fifa");
        game.setQuantity(40);


        Game game2 = new Game();
        game2.setTitle("Fifa 23");
        game2.setEsrb_rating("Rated E");
        game2.setDescription("For everyone");
        game2.setPrice(new BigDecimal("49.99"));
        game2.setStudio("Fifa");
        game2.setQuantity(40);

        game2 = service.saveGame(game2);
        game2 = service.findGame(10);
        assertEquals(game, game2);
    }

    @Test
    public void shouldSaveInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId(1);
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

        Invoice invoice2 = new Invoice();
        invoice2.setName("David");
        invoice2.setStreet("100 winchester Circle");
        invoice2.setCity("Los Gatos");
        invoice2.setState("CA");
        invoice2.setZipcode("95032");
        invoice2.setItem_type("Console");
        invoice2.setItem_id(25);
        invoice2.setUnit_price(new BigDecimal("399.99"));
        invoice2.setQuantity(50);
        invoice2.setSubtotal(new BigDecimal("500.00"));
        invoice2.setTax(new BigDecimal("1.50"));
        invoice2.setProcessing_fee(new BigDecimal("6.99"));
        invoice2.setTotal(new BigDecimal("550.00"));

        invoice2 = service.saveInvoice(invoice2);
        assertEquals(invoice, invoice2);
    }

    @Test
    public void shouldFindInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId(1);
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

        Invoice invoice2 = new Invoice();
        invoice2.setName("David");
        invoice2.setStreet("100 winchester Circle");
        invoice2.setCity("Los Gatos");
        invoice2.setState("CA");
        invoice2.setZipcode("95032");
        invoice2.setItem_type("Console");
        invoice2.setItem_id(25);
        invoice2.setUnit_price(new BigDecimal("399.99"));
        invoice2.setQuantity(50);
        invoice2.setSubtotal(new BigDecimal("500.00"));
        invoice2.setTax(new BigDecimal("1.50"));
        invoice2.setProcessing_fee(new BigDecimal("6.99"));
        invoice2.setTotal(new BigDecimal("550.00"));

        invoice2 = service.saveInvoice(invoice2);
        invoice2 = service.findInvoice(1);
        assertEquals(invoice, invoice2);
    }

    @Test
    public void shouldSaveT_shirt() {
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setId(45);
        t_shirt.setSize("Medium");
        t_shirt.setColor("Black");
        t_shirt.setDescription("Great TShirt for everyone");
        t_shirt.setPrice(new BigDecimal("29.99"));
        t_shirt.setQuantity(200);

        T_Shirt t_shirt2 = new T_Shirt();
        t_shirt2.setSize("Medium");
        t_shirt2.setColor("Black");
        t_shirt2.setDescription("Great TShirt for everyone");
        t_shirt2.setPrice(new BigDecimal("29.99"));
        t_shirt2.setQuantity(200);

        t_shirt2 = service.saveTshirt(t_shirt2);
        assertEquals(t_shirt, t_shirt2);
    }

    @Test
    public void shouldFindT_shirt() {
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setId(45);
        t_shirt.setSize("Medium");
        t_shirt.setColor("Black");
        t_shirt.setDescription("Great TShirt for everyone");
        t_shirt.setPrice(new BigDecimal("29.99"));
        t_shirt.setQuantity(200);

        T_Shirt t_shirt2 = new T_Shirt();
        t_shirt2.setSize("Medium");
        t_shirt2.setColor("Black");
        t_shirt2.setDescription("Great TShirt for everyone");
        t_shirt2.setPrice(new BigDecimal("29.99"));
        t_shirt2.setQuantity(200);

        t_shirt2 = service.saveTshirt(t_shirt2);
        t_shirt2 = service.findTShirt(45);
        assertEquals(t_shirt, t_shirt2);
    }

    private void setUpConsoleRepositoryMock() {
        consoleRepository = mock(ConsoleRepository.class);

        Console console = new Console();
        console.setId(1);
        console.setModel("2020");
        console.setManufacturer("Playstation");
        console.setMemory_amount("2TB");
        console.setProcessor("GoodProcessor");
        console.setPrice(new BigDecimal("799.99"));
        console.setQuantity(150);

        Console console2 = new Console();
        console2.setModel("2020");
        console2.setManufacturer("Playstation");
        console2.setMemory_amount("2TB");
        console2.setProcessor("GoodProcessor");
        console2.setPrice(new BigDecimal("799.99"));
        console2.setQuantity(150);

        List<Console> cList = new ArrayList<>();
        cList.add(console);

        doReturn(console).when(consoleRepository).save(console2);
        doReturn(Optional.of(console)).when(consoleRepository).findById(1);
        doReturn(cList).when(consoleRepository).findAll();
    }

    private void setUpGameRepositoryMock() {
        gameRepository = mock(GameRepository.class);
        Game game = new Game();
        game.setId(10);
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated E");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Fifa");
        game.setQuantity(40);


        Game game2 = new Game();
        game2.setTitle("Fifa 23");
        game2.setEsrb_rating("Rated E");
        game2.setDescription("For everyone");
        game2.setPrice(new BigDecimal("49.99"));
        game2.setStudio("Fifa");
        game2.setQuantity(40);

        List gList = new ArrayList<>();
        gList.add(game);

        doReturn(game).when(gameRepository).save(game2);
        doReturn(Optional.of(game)).when(gameRepository).findById(10);
        doReturn(gList).when(gameRepository).findAll();
    }

    private void setUpInvoiceRepositoryMock() {
        invoiceRepository = mock(InvoiceRepository.class);

        Invoice invoice = new Invoice();
        invoice.setId(1);
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

        Invoice invoice2 = new Invoice();
        invoice2.setName("David");
        invoice2.setStreet("100 winchester Circle");
        invoice2.setCity("Los Gatos");
        invoice2.setState("CA");
        invoice2.setZipcode("95032");
        invoice2.setItem_type("Console");
        invoice2.setItem_id(25);
        invoice2.setUnit_price(new BigDecimal("399.99"));
        invoice2.setQuantity(50);
        invoice2.setSubtotal(new BigDecimal("500.00"));
        invoice2.setTax(new BigDecimal("1.50"));
        invoice2.setProcessing_fee(new BigDecimal("6.99"));
        invoice2.setTotal(new BigDecimal("550.00"));

        List iList = new ArrayList<>();
        iList.add(invoice);

        doReturn(invoice).when(invoiceRepository).save(invoice2);
        doReturn(Optional.of(invoice)).when(invoiceRepository).findById(1);
        doReturn(iList).when(invoiceRepository).findAll();
    }

    private void setUpT_shirtsRepositoryMock() {
        t_shirtsRepository = mock(T_shirtsRepository.class);

        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setId(45);
        t_shirt.setSize("Medium");
        t_shirt.setColor("Black");
        t_shirt.setDescription("Great TShirt for everyone");
        t_shirt.setPrice(new BigDecimal("29.99"));
        t_shirt.setQuantity(200);

        T_Shirt t_shirt2 = new T_Shirt();
        t_shirt2.setSize("Medium");
        t_shirt2.setColor("Black");
        t_shirt2.setDescription("Great TShirt for everyone");
        t_shirt2.setPrice(new BigDecimal("29.99"));
        t_shirt2.setQuantity(200);

        List tList = new ArrayList<>();
        tList.add(t_shirt);

        doReturn(t_shirt).when(t_shirtsRepository).save(t_shirt2);
        doReturn(Optional.of(t_shirt)).when(t_shirtsRepository).findById(45);
        doReturn(tList).when(t_shirtsRepository).findAll();
    }
}
