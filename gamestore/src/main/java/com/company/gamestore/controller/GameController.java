package com.company.gamestore.controller;


import com.company.gamestore.model.Game;
import com.company.gamestore.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    GameRepository repo;

    @PostMapping("/game")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody Game game){
        return repo.save(game);
    }

    @PutMapping("/game")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Game updateGame(@RequestBody Game game){
        return repo.save(game);
    }

    @DeleteMapping("/game/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        repo.deleteById(id);
    }

    @GetMapping("/game/id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Game> getGameById(@PathVariable int id){
        return  repo.findById(id);
    }

    @GetMapping("/game")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameAllGames(){
        return  repo.findAll();
    }

    @GetMapping("/game/studio/{Studio}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameByStudio(@PathVariable String studio){
        return  repo.findByStudio(studio);
    }

    @GetMapping("/game/esrb/{Esrb}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameEsrb(@PathVariable String Esrb){
        return  repo.findByStudio(Esrb);
    }

    @GetMapping("/game/title/{Title}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameByTitle(@PathVariable String Title){
        return  repo.findByStudio(Title);
    }



}
