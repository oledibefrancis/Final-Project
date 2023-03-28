package com.company.gamestore.controller;


import com.company.gamestore.model.Invoice;
import com.company.gamestore.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceRepository repo;

    @PostMapping("/Invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createCustomer(@RequestBody Invoice invoice){
        return repo.save(invoice);
    }

    @PutMapping("/Invoice")
    @ResponseStatus(value = HttpStatus.OK)
    public Invoice updateCustomer(@RequestBody Invoice invoice){
        return repo.save(invoice);
    }

    @DeleteMapping("/Invoice/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable int id){
        repo.deleteById(id);
    }

    @GetMapping("/Invoice/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Invoice> getCustomer(@PathVariable int id){
        return  repo.findById(id);
    }

}
