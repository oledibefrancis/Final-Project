package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Game;
import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;
@Controller
public class GraphController {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    ConsoleRepository consoleRepository;


    @QueryMapping
    public List<Game> findAllGames(){
        return gameRepository.findAll();
    }

    @QueryMapping
    public List<Console> findAllConsoles(){
        return consoleRepository.findAll();
    }
    @QueryMapping()
    public Game findByGameId(@Argument Integer game_id){
        return gameRepository.findById(game_id).get();
    }

    @QueryMapping()
    public Console findByConsoleId(@Argument Integer console_id){
        return consoleRepository.findById(console_id).get();
    }

    @QueryMapping()
    public List<Game> findByGameTitle(@Argument String title){
        return gameRepository.findByTitle(title);
    }

    @QueryMapping
    public List<Game> findGameByESRB(@Argument String esrb){
        return gameRepository.findByEsrbRating(esrb);
    }

    @QueryMapping
    public List<Game> findGameByStudio(@Argument String studio){
        return gameRepository.findByStudio(studio);
    }

    @QueryMapping
    public List<Console> findConsoleByManufacturer(@Argument String manufacturer){
        return consoleRepository.findByManufacturer(manufacturer);
    }



}
