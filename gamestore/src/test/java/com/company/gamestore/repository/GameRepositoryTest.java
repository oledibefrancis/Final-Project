package com.company.gamestore.repository;

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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameRepositoryTest {
    @Autowired
    GameRepository gameRepository;


    @Before
    public void setUp() {
        gameRepository.deleteAll();
    }

    @Test
    public void shouldAddAndGetGame() {

        Game game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        game = gameRepository.save(game);

        //Assert...
        Optional<Game> game1 = gameRepository.findById(game.getId());

        assertEquals(game1.get(), game);

    }

    @Test
    public void shouldGetAllGames() {

        Game game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        gameRepository.save(game);

        game = new Game();
        game.setTitle("Fortnite");
        game.setEsrb_rating("Rated T");
        game.setDescription("A game where you make people until the end where there is only 1 left");
        game.setPrice(new BigDecimal("00.00"));
        game.setStudio("Epic Games");
        game.setQuantity(700);

        gameRepository.save(game);
        List<Game> gameList = gameRepository.findAll();

        assertEquals(gameList.size(), 2);
    }

    @Test
    public void shouldUpdateGame() {

        Game game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        game = gameRepository.save(game);

        game.setTitle("FIFA");

        game = gameRepository.save(game);

        //Assert...
        Optional<Game> game1 = gameRepository.findById(game.getId());

        assertEquals(game1.get(),game);
    }

    @Test
    public void shouldGetGamesByStudio() {

        Game game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        gameRepository.save(game);

        game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Square");
        game.setQuantity(400);

        gameRepository.save(game);

        game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Square");
        game.setQuantity(300);

        gameRepository.save(game);
        List<Game> mList = gameRepository.findByStudio("Square");

        assertEquals(2, mList.size());

        mList = gameRepository.findByStudio("Bethesda");

        assertEquals(1, mList.size());

        mList = gameRepository.findByStudio("Epic Games");

        assertEquals(0, mList.size());
    }
    @Test
    public void shouldGetGamesByESRB_Rating() {

        Game game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        gameRepository.save(game);

        game = new Game();
        game.setTitle("PayDay");
        game.setEsrb_rating("Rated M");
        game.setDescription("A game where you essentially rob banks");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        gameRepository.save(game);

        game = new Game();
        game.setTitle("Red Dead Redemption");
        game.setEsrb_rating("Rated M");
        game.setDescription("A game where you play an outlaw in the West");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        gameRepository.save(game);
        List<Game> mList = gameRepository.findByEsrb("Rated M");

        assertEquals(2, mList.size());

        mList = gameRepository.findByEsrb("Rated E");

        assertEquals(1, mList.size());

        mList = gameRepository.findByEsrb("Rated T");

        assertEquals(0, mList.size());
    }

    @Test
    public void shouldGetGamesByTitle() {

        Game game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        gameRepository.save(game);

        game = new Game();
        game.setTitle("Red Dead Redemption");
        game.setEsrb_rating("Rated M");
        game.setDescription("A game where you play an outlaw in the West");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        gameRepository.save(game);

        game = new Game();
        game.setTitle("Red Dead Redemption");
        game.setEsrb_rating("Rated M");
        game.setDescription("A game where you play an outlaw in the West");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(500);

        gameRepository.save(game);
        List<Game> mList = gameRepository.findByTitle("Red Dead Redemption");

        assertEquals(2, mList.size());

        mList = gameRepository.findByTitle("Portal");

        assertEquals(1, mList.size());

        mList = gameRepository.findByTitle("FIFA");

        assertEquals(0, mList.size());
    }

    @Test
    public void shouldDeleteGame() {
        Game game = new Game();
        game.setTitle("Portal");
        game.setEsrb_rating("Rated E");
        game.setDescription("A game where you make portals to solve puzzles");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bethesda");
        game.setQuantity(400);

        gameRepository.save(game);

        //ACT
        gameRepository.deleteById(game.getId());

        //Assert...
        Optional<Game> game1 = gameRepository.findById(game.getId());
        assertFalse(game1.isPresent());

    }

}