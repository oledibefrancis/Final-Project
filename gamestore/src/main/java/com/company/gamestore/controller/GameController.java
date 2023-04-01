package com.company.gamestore.controller;


import com.company.gamestore.model.Game;
import com.company.gamestore.repository.GameRepository;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping("/game")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody Game game){
        return serviceLayer.saveGame(game);
    }

    @PutMapping("/game")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody Game game){
        serviceLayer.updateGame(game);
    }

    @DeleteMapping("/game/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        serviceLayer.deleteGame(id);
    }

    @GetMapping("/game/id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGameById(@PathVariable int id){
        return serviceLayer.findGame(id);
    }

    @GetMapping("/game")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameAllGames(){
        return  serviceLayer.findAllGames();
    }

    @GetMapping("/game/studio/{Studio}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameByStudio(@PathVariable String studio){
        return  serviceLayer.findByStudio(studio);
    }

    @GetMapping("/game/esrb/{Esrb}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameEsrb(@PathVariable String Esrb){
        return  serviceLayer.findByStudio(Esrb);
    }

    @GetMapping("/game/title/{Title}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameByTitle(@PathVariable String Title){
        return  serviceLayer.findByStudio(Title);
    }



}
