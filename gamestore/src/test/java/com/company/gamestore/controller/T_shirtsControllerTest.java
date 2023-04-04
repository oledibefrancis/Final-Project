package com.company.gamestore.controller;

import com.company.gamestore.model.Game;
import com.company.gamestore.model.T_Shirt;
import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.repository.GameRepository;
import com.company.gamestore.repository.InvoiceRepository;
import com.company.gamestore.repository.T_shirtsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(T_shirtsController.class)
public class T_shirtsControllerTest {
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

    public T_Shirt createTShirt() {
        T_Shirt tShirt = new T_Shirt();
        tShirt.setColor("green");
        tShirt.setDescription("nike t-shirt for childre");
        tShirt.setPrice(BigDecimal.valueOf(40));
        tShirt.setSize("large");
        tShirt.setQuantity(100);
        return tShirt;
    }


    @Test
    public void testCreateTshirt() throws Exception {
        T_Shirt tShirt = createTShirt();

//        when(t_shirtsRepository.findById(tShirt.getId())).thenReturn(Optional.of(tShirt));

        String inputJson = mapper.writeValueAsString(tShirt);

        mockMvc.perform(
                        post("/t_shirts")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAllTshirt() throws Exception {
        mockMvc.perform(get("/t_shirts"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void testUpdateTShirt() throws Exception {
        T_Shirt tShirt = createTShirt();

        when(t_shirtsRepository.findById(tShirt.getId())).thenReturn(Optional.of(tShirt));

        String inputJson = mapper.writeValueAsString(tShirt);

        mockMvc.perform(
                        put("/t_shirts")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteGame() throws Exception {
        T_Shirt tShirt = createTShirt();

        when(t_shirtsRepository.findById(tShirt.getId())).thenReturn(Optional.of(tShirt));

        t_shirtsRepository.deleteById(tShirt.getId());

        mockMvc.perform(delete("/t_shirts/" + tShirt.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}