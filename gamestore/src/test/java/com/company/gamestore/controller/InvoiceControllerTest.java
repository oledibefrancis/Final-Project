package com.company.gamestore.controller;

import com.company.gamestore.model.Game;
import com.company.gamestore.model.Invoice;
import com.company.gamestore.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
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
@AutoConfigureMockMvc(addFilters = false)
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

    @MockBean
    FeeRepository feeRepository;

    @MockBean
    TaxRepository taxRepository;

    private final ObjectMapper mapper = new ObjectMapper();

    public Invoice createInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Customer 1");
        invoice.setCity("Clovis");
        invoice.setStreet("100 Main Street");
        invoice.setState("CA");
        invoice.setZipcode("93612");
        invoice.setItem_type("Game");
        invoice.setItem_id(70);
        invoice.setQuantity(12);
        return invoice;
    }

    public Invoice expectedInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Customer 1");
        invoice.setCity("Clovis");
        invoice.setStreet("100 Main Street");
        invoice.setState("CA");
        invoice.setZipcode("93612");
        invoice.setItem_type("Game");
        invoice.setItem_id(70);
        invoice.setQuantity(12);
        invoice.setUnit_price(BigDecimal.valueOf(49.99));
        invoice.setSubtotal(BigDecimal.valueOf(599.88));
        invoice.setTax(BigDecimal.valueOf(35.9928));
        invoice.setProcessing_fee(BigDecimal.valueOf(16.98));
        invoice.setTotal(BigDecimal.valueOf(652.8528));
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