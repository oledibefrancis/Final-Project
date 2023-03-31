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
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated E");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Fifa");
        game.setQuantity(40);

        game = gameRepository.save(game);

        Optional<Game> game1 = gameRepository.findById(game.getId());

        assertEquals(game1.get(), game);

    }

    @Test
    public void shouldGetAllGames() {

        Game game = new Game();
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated E");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Fifa");
        game.setQuantity(40);

        gameRepository.save(game);

        game = new Game();
        game.setTitle("Fortnite");
        game.setEsrb_rating("Rated T");
        game.setDescription("A game where you make people until the end where there is only 1 left");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Epic Games");
        game.setQuantity(70);

        gameRepository.save(game);
        List<Game> gameList = gameRepository.findAll();

        assertEquals(gameList.size(), 2);
    }

    @Test
    public void shouldUpdateGame() {

        Game game = new Game();
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated E");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Fifa");
        game.setQuantity(40);

        game = gameRepository.save(game);

        game.setTitle("FIFA");

        game = gameRepository.save(game);

        Optional<Game> game1 = gameRepository.findById(game.getId());

        assertEquals(game1.get(), game);
    }

    @Test
    public void shouldGetGamesByStudio() {

        Game game = new Game();
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated E");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Fifa");
        game.setQuantity(40);

        gameRepository.save(game);

        game = new Game();
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated E");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Square");
        game.setQuantity(40);

        gameRepository.save(game);

        game = new Game();
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated E");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Square");
        game.setQuantity(40);

        gameRepository.save(game);
        List<Game> mList = gameRepository.findByStudio("Square");

        assertEquals(2, mList.size());

        mList = gameRepository.findByStudio("Fifa");

        assertEquals(1, mList.size());

        mList = gameRepository.findByStudio("Epic Games");

        assertEquals(0, mList.size());
    }

    @Test
    public void shouldGetGamesByESRB_Rating() {

        Game game = new Game();
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated M");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Fifa");
        game.setQuantity(40);

        gameRepository.save(game);

        game = new Game();
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated M");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Square");
        game.setQuantity(40);

        gameRepository.save(game);

        game = new Game();
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated E");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Square");
        game.setQuantity(40);


        gameRepository.save(game);
        List<Game> mList = gameRepository.findByEsrbRating("Rated M");

        assertEquals(2, mList.size());

        mList = gameRepository.findByEsrbRating("Rated E");

        assertEquals(1, mList.size());

        mList = gameRepository.findByEsrbRating("Rated T");

        assertEquals(0, mList.size());
    }

    @Test
    public void shouldGetGamesByTitle() {

        Game game = new Game();
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated M");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Fifa");
        game.setQuantity(40);

        gameRepository.save(game);

        game = new Game();
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated M");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Square");
        game.setQuantity(40);

        gameRepository.save(game);

        game = new Game();
        game.setTitle("FIFA");
        game.setEsrb_rating("Rated M");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Square");
        game.setQuantity(40);

        gameRepository.save(game);
        List<Game> mList = gameRepository.findByTitle("Fifa 23");

        assertEquals(2, mList.size());

        mList = gameRepository.findByTitle("Portal");

        assertEquals(0, mList.size());

        mList = gameRepository.findByTitle("FIFA");

        assertEquals(1, mList.size());
    }

    @Test
    public void shouldDeleteGame() {
        Game game = new Game();
        game.setTitle("Fifa 23");
        game.setEsrb_rating("Rated M");
        game.setDescription("For everyone");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Fifa");
        game.setQuantity(40);

        gameRepository.save(game);

        gameRepository.deleteById(game.getId());

        Optional<Game> game1 = gameRepository.findById(game.getId());
        assertFalse(game1.isPresent());

    }

}