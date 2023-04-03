package com.company.gamestore.controller;


import com.company.gamestore.model.T_Shirt;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class T_shirtsController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping("/t_shirts")
    @ResponseStatus(HttpStatus.CREATED)
    public T_Shirt createTShirt(@RequestBody T_Shirt tShirts){
        return serviceLayer.saveTshirt(tShirts);
    }

    @PutMapping("/t_shirts")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateTShirt(@RequestBody T_Shirt tShirt){
         serviceLayer.updateTShirt(tShirt);
    }


    @DeleteMapping("/t_shirts/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable int id){
        serviceLayer.deleteTShirt(id);
    }

    @GetMapping("/t_shirts/id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public T_Shirt getTShirtById(@PathVariable int id){
        return  serviceLayer.findTShirt(id);
    }

    @GetMapping("/t_shirts")
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getAllTShirt(){
        return  serviceLayer.findAllTShirts();
    }

    @GetMapping("/t_shirts/color/{color}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getTShirtByColor(@PathVariable String color){
        return  serviceLayer.findByColor(color);
    }

    @GetMapping("/t_shirts/size/{size}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getTShirtBySize(@PathVariable String size){
        return  serviceLayer.findBySize(size);
    }
}
