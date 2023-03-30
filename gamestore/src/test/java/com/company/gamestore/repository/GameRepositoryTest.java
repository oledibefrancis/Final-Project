package com.company.gamestore.repository;

import com.company.gamestore.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameRepositoryTest {
    @Autowired
    GameRepository gameRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    T_shirtsRepository t_shirtsRepository;

    @Before
    public void setUp() {
        gameRepository.deleteAll();
        invoiceRepository.deleteAll();
        t_shirtsRepository.deleteAll();
    }

//    @Test
//    public void addAndGetGame() {
//
//        Game game = new Game();
//        game.setTitle("Portal");
//        game.setEsrb_rating("Rated E");
//        game.setDescription("A game where you make portals to solve puzzles");
//        game.setPrice(new BigDecimal("59.99"));
//        game.setStudio("Bethesda");
//        game.setQuantity(400);
//
//        game = gameRepository.save(game);
//
//        //Assert...
//        Optional<Game> game1 = gameRepository.findById(game.getId());
//
//        assertEquals(game1.get(), game);
//
//    }

}