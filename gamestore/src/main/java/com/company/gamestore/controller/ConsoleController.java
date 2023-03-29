package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Game;
import com.company.gamestore.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ConsoleController {

    @Autowired
    ConsoleRepository repo;


    @PostMapping("/Console")
    @ResponseStatus(HttpStatus.CREATED)
    public Console createConsole(@RequestBody Console console){
        return repo.save(console);
    }

    @PutMapping("/Console")
    @ResponseStatus(value = HttpStatus.OK)
    public Console updateConsole(@RequestBody Console console){
        return repo.save(console);
    }

    @DeleteMapping("/Console/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteConsole(@PathVariable int id){
        repo.deleteById(id);
    }

    @GetMapping("/Console/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Console> getConsoleById(@PathVariable int id){
        return  repo.findById(id);
    }

    @GetMapping("/Console/manufacturer")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsoleByManufacturer(@PathVariable String manufacturer){
        return  repo.findByManufacturer(manufacturer);
    }

    @GetMapping("Console")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsole(){
        return repo.findAll();
    }
}