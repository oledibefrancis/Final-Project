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
    public Invoice createInvoice(@RequestBody Invoice invoice){
        return repo.save(invoice);
    }

    @GetMapping("/Invoice")
    @ResponseStatus(value = HttpStatus.OK)
    public void getAllInvoice(){
        repo.findAll();
    }

    @GetMapping("/Invoice/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Invoice> getInvoiceById(@PathVariable int id){
        return  repo.findById(id);
    }

    @GetMapping("/Invoice/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    public Invoice getInvoiceByCustomerName(@PathVariable String name){
        return  repo.findByName(name);
    }
}
