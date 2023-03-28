package com.company.gamestore.controller;


import com.company.gamestore.model.Invoice;
import com.company.gamestore.model.T_Shirt;
import com.company.gamestore.repository.InvoiceRepository;
import com.company.gamestore.repository.T_shirtsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class T_shirtsController {

    @Autowired
    T_shirtsRepository repo;

    @PostMapping("/T_shirts")
    @ResponseStatus(HttpStatus.CREATED)
    public T_Shirt createTShirt(@RequestBody T_Shirt tShirts){
        return repo.save(tShirts);
    }

    @PutMapping("/T_shirts")
    @ResponseStatus(value = HttpStatus.OK)
    public T_Shirt updateTShirt(@RequestBody T_Shirt tShirt){
        return repo.save(tShirt);
    }


    @DeleteMapping("/T_shirts/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTShirt(@PathVariable int id){
        repo.deleteById(id);
    }

    @GetMapping("/T_shirts/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<T_Shirt> getTShirt(@PathVariable int id){
        return  repo.findById(id);
    }
}
