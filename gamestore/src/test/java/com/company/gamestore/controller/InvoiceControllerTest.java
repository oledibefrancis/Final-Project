package com.company.gamestore.controller;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {
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

    public Invoice createInvoice() {
        Invoice invoice = new Invoice();
        invoice.setCity("New York");
        invoice.setSubtotal(BigDecimal.valueOf(30));
        invoice.setQuantity(86);
        invoice.setName("fifa 23");
        invoice.setQuantity(23);
        invoice.setProcessing_fee(BigDecimal.valueOf(30));
        invoice.setItem_type("New type");
        invoice.setStreet("new street");
        invoice.setItem_id(10);
        invoice.setUnit_price(BigDecimal.valueOf(93));
        invoice.setZipcode("101212");
        invoice.setTax(BigDecimal.valueOf(30));
        invoice.setItem_type("Adventure game");
        invoice.setTotal(BigDecimal.valueOf(30));
        return invoice;
    }



    @Before
    public void setUp() throws Exception {
        invoiceRepository.deleteAll();
    }



    @Test
    public void testGetAllInvoice() throws Exception {
        mockMvc.perform(get("/invoice"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void testAddGame() throws Exception {
        Invoice invoice = createInvoice();

        when(invoiceRepository.findById(invoice.getId())).thenReturn(Optional.of(invoice));

        String inputJson = mapper.writeValueAsString(invoice);

        mockMvc.perform(
                        post("/invoice")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }
    @Test
    public void testGetInvoiceByName() throws Exception {
        Invoice invoice = createInvoice();
        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice);

        when(invoiceRepository.findByName(invoice.getName())).thenReturn(invoiceList);

        mockMvc.perform(get("/invoice/name/" + invoice.getName()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetInvoiceById() throws Exception {
        Invoice invoice = createInvoice();

        when(invoiceRepository.findById(invoice.getId())).thenReturn(Optional.of(invoice));

        mockMvc.perform(get("/invoice/id/" + invoice.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

}