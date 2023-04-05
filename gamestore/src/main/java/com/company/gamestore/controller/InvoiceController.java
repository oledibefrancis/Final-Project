package com.company.gamestore.controller;


import com.company.gamestore.model.Invoice;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@ComponentScan("com.company.gamestore.service")
public class InvoiceController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping("/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody Invoice invoice){
        return serviceLayer.saveInvoice(invoice);
    }

    @GetMapping("/invoice")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> getAllInvoice(){
        return serviceLayer.findAllInvoices();
    }

    @GetMapping("/invoice/id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Invoice getInvoiceById(@PathVariable int id){
        return serviceLayer.findInvoice(id);
    }

    @GetMapping("/invoice/name/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> getInvoiceByCustomerName(@PathVariable String name){
        return  serviceLayer.findByName(name);
    }
}
