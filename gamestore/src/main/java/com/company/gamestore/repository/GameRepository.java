package com.company.gamestore.repository;

import com.company.gamestore.model.Game;
import com.company.gamestore.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Integer> {

    List<Game> findByEsrb(String esrbRating);
    List<Game> findByStudio(String studio);
    List<Game> findByTitle(String title);

}
