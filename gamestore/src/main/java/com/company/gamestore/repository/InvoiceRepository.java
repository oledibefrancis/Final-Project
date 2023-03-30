package com.company.gamestore.repository;

import com.company.gamestore.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

    Invoice findByName(String name);

}
