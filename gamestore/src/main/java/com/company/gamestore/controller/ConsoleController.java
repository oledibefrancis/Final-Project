package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ConsoleController {

    @Autowired
    ConsoleRepository repo;


    @PostMapping("/console")
    @ResponseStatus(HttpStatus.CREATED)
    public Console createConsole(@RequestBody Console console){
        return repo.save(console);
    }

    @PutMapping("/console")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Console updateConsole(@RequestBody Console console){
        return repo.save(console);
    }

    @DeleteMapping("/console/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id){
        repo.deleteById(id);
    }

    @GetMapping("/console/id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Console> getConsoleById(@PathVariable int id){
        return  repo.findById(id);
    }

<<<<<<< HEAD
    @GetMapping("/console/{manufacturer}")
=======
    @GetMapping("/console/manufacturer/{manufacturer}")
>>>>>>> a494d2ded48903a8ca1adabd96c75aae631f17b4
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsoleByManufacturer(@PathVariable String manufacturer){
        return  repo.findByManufacturer(manufacturer);
    }

    @GetMapping("/console")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsole(){
        return repo.findAll();
    }
}
