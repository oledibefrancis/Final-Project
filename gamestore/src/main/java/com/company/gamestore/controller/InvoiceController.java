package com.company.gamestore.controller;


import com.company.gamestore.model.Invoice;
import com.company.gamestore.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceRepository repo;

    @PostMapping("/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody Invoice invoice){
        return repo.save(invoice);
    }

    @GetMapping("/invoice")
    @ResponseStatus(value = HttpStatus.OK)
    public void getAllInvoice(){
        repo.findAll();
    }

    @GetMapping("/invoice/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Invoice> getInvoiceById(@PathVariable int id){
        return  repo.findById(id);
    }

    @GetMapping("/invoice/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    public Invoice getInvoiceByCustomerName(@PathVariable String name){
        return  repo.findByName(name);
    }
}
