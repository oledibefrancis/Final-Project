package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Game;
import com.company.gamestore.model.Invoice;
import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.repository.GameRepository;
import com.company.gamestore.repository.InvoiceRepository;
import com.company.gamestore.repository.T_shirtsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ConsoleRepository consoleRepository;

    @MockBean
    GameRepository gameRepository;

    @MockBean
    InvoiceRepository invoiceRepository;

    @MockBean
    T_shirtsRepository t_shirtsRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public Console createConsole() {
        Console console = new Console();
        console.setPrice(BigDecimal.valueOf(900.00));
        console.setManufacturer("Play Station");
        console.setQuantity(8);
        console.setModel("2019");
        console.setMemory_amount("45");
        console.setProcessor("CPU");
        return console;
    }

    @Before
    public void setUp() throws Exception {
        consoleRepository.deleteAll();
    }



    @Test
    public void testGetAllGames() throws Exception {
        mockMvc.perform(get("/console"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetConsoleById() throws Exception {
        Console console = createConsole();

//        when(consoleRepository.findById(console.getId())).thenReturn(Optional.of(console));

        mockMvc.perform(get("/console/id/" + console.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void testCreateConsole() throws Exception {
        Console console = createConsole();

        when(consoleRepository.findById(console.getId())).thenReturn(Optional.of(console));

        String inputJson = mapper.writeValueAsString(console);

        mockMvc.perform(
                        post("/console")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateConsole() throws Exception {
        Console console = createConsole();

        when(consoleRepository.findById(console.getId())).thenReturn(Optional.of(console));

        String inputJson = mapper.writeValueAsString(console);

        mockMvc.perform(
                        put("/console")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteConsole() throws Exception {
        Console console = createConsole();

        when(consoleRepository.findById(console.getId())).thenReturn(Optional.of(console));

        consoleRepository.deleteById(console.getId());

        mockMvc.perform(delete("/console/" + console.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}