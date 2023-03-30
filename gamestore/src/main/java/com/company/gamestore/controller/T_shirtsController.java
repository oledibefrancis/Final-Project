package com.company.gamestore.controller;


import com.company.gamestore.model.T_Shirt;
import com.company.gamestore.repository.T_shirtsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class T_shirtsController {

    @Autowired
    T_shirtsRepository repo;

    @PostMapping("/t_shirts")
    @ResponseStatus(HttpStatus.CREATED)
    public T_Shirt createTShirt(@RequestBody T_Shirt tShirts){
        return repo.save(tShirts);
    }

    @PutMapping("/t_shirts")
    @ResponseStatus(value = HttpStatus.OK)
    public T_Shirt updateTShirt(@RequestBody T_Shirt tShirt){
        return repo.save(tShirt);
    }


    @DeleteMapping("/t_shirts/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTShirt(@PathVariable int id){
        repo.deleteById(id);
    }

    @GetMapping("/t_shirts/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<T_Shirt> getTShirtById(@PathVariable int id){
        return  repo.findById(id);
    }

    @GetMapping("/t_shirts")
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getAllTShirt(){
        return  repo.findAll();
    }

    @GetMapping("/t_shirts/{color}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getTShirtByColor(@PathVariable String color){
        return  repo.findByColor(color);
    }

    @GetMapping("/t_shirts/{size}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getTShirtBySize(@PathVariable String size){
        return  repo.findBySize(size);
    }
}
