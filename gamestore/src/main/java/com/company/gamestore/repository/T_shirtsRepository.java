package com.company.gamestore.repository;

import com.company.gamestore.model.Invoice;
import com.company.gamestore.model.T_Shirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public interface T_shirtsRepository extends JpaRepository<T_Shirt,Integer> {
    String findByColor(String color);
    String findBySize(String size);
}
