package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ConsoleController {

    @Autowired
    ServiceLayer serviceLayer;


    @PostMapping("/console")
    @ResponseStatus(HttpStatus.CREATED)
    public Console createConsole(@RequestBody Console console){
        return serviceLayer.saveConsole(console);
    }

    @PutMapping("/console")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Console updateConsole(@RequestBody Console console){
        return serviceLayer.saveConsole(console);
    }

    @DeleteMapping("/console/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id){
        serviceLayer.deleteConsole(id);
    }

    @GetMapping("/console/id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsoleById(@PathVariable int id){
        return  serviceLayer.findConsole(id);
    }

    @GetMapping("/console/manufacturer/{manufacturer}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsoleByManufacturer(@PathVariable String manufacturer){
        return  serviceLayer.findByManufacturer(manufacturer);
    }

    @GetMapping("/console")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsole(){
        return serviceLayer.findAllConsoles();
    }
}
