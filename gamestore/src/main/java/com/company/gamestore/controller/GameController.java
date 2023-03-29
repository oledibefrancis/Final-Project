package com.company.gamestore.controller;


import com.company.gamestore.model.Game;
import com.company.gamestore.model.Invoice;
import com.company.gamestore.repository.GameRepository;
import com.company.gamestore.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    GameRepository repo;

    @PostMapping("/Game")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody Game game){
        return repo.save(game);
    }

    @PutMapping("/Game")
    @ResponseStatus(value = HttpStatus.OK)
    public Game updateGame(@RequestBody Game game){
        return repo.save(game);
    }

    @DeleteMapping("/Game/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable int id){
        repo.deleteById(id);
    }

    @GetMapping("/Game/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Game> getGameById(@PathVariable int id){
        return  repo.findById(id);
    }

    @GetMapping("/Game")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameAllGames(){
        return  repo.findAll();
    }

    @GetMapping("/Game/{Studio}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameByStudio(@PathVariable String studio){
        return  repo.findByStudio(studio);
    }

    @GetMapping("/Game/{Esrb}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameEsrb(@PathVariable String Esrb){
        return  repo.findByStudio(Esrb);
    }

    @GetMapping("/Game/{Title}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameByTitle(@PathVariable String Title){
        return  repo.findByStudio(Title);
    }



}
