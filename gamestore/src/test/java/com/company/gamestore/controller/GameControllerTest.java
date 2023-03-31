package com.company.gamestore.controller;

import com.company.gamestore.model.Game;
import com.company.gamestore.repository.GameRepository;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GameRepository gameRepository;

    private final ObjectMapper mapper = new ObjectMapper();


    public Game createGame() {
        Game game = new Game();
        game.setTitle("Fifa 23");
        game.setPrice(BigDecimal.valueOf(30));
        game.setStudio("Fifa");
        game.setQuantity(10);
        game.setDescription("For everyone");
        game.setEsrb_rating("18");
        return game;
    }


    @Before
    public void setUp() throws Exception {
        gameRepository.deleteAll();
    }


    @Test
    public void testGetAllGames() throws Exception {
        mockMvc.perform(get("/game"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void testAddGame() throws Exception {
        Game game = createGame();

        when(gameRepository.findById(game.getId())).thenReturn(Optional.of(game));

        String inputJson = mapper.writeValueAsString(game);

        mockMvc.perform(
                        post("/game")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateGame() throws Exception {
        Game game = createGame();

        when(gameRepository.findById(game.getId())).thenReturn(Optional.of(game));

        String inputJson = mapper.writeValueAsString(game);

        mockMvc.perform(
                        put("/game")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteGame() throws Exception {
        Game game = createGame();

        when(gameRepository.findById(game.getId())).thenReturn(Optional.of(game));

        gameRepository.deleteById(game.getId());

        mockMvc.perform(delete("/game/" + game.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}