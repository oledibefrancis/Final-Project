package com.company.gamestore.service;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Game;
import com.company.gamestore.model.Invoice;
import com.company.gamestore.model.T_Shirt;
import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.repository.GameRepository;
import com.company.gamestore.repository.InvoiceRepository;
import com.company.gamestore.repository.T_shirtsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServiceLayer {
    private ConsoleRepository consoleRepository;
    private GameRepository gameRepository;
    private InvoiceRepository invoiceRepository;
    private T_shirtsRepository t_shirtsRepository;

    @Autowired
    public ServiceLayer(ConsoleRepository consoleRepository, GameRepository gameRepository, InvoiceRepository invoiceRepository, T_shirtsRepository t_shirtsRepository) {
        this.consoleRepository = consoleRepository;
        this.gameRepository = gameRepository;
        this.invoiceRepository = invoiceRepository;
        this.t_shirtsRepository = t_shirtsRepository;
    }

    //
    // Console API
    //

    public Console saveConsole(Console console) {

        return consoleRepository.save(console);
    }

    public Console findConsole(int id) {

        Optional<Console> console = consoleRepository.findById(id);
        return console.isPresent() ? console.get() : null;
    }

    public List<Console> findAllConsoles() {

        return consoleRepository.findAll();
    }

    public void updateConsole(Console console) {

        consoleRepository.save(console);
    }

    public void deleteConsole(int id) {

        consoleRepository.deleteById(id);
    }
    public List<Console> findByManufacturer(String manufacturer){
        return consoleRepository.findByManufacturer(manufacturer);
    }




    //
    // Game API
    //

    public Game saveGame(Game game) {

        return gameRepository.save(game);
    }

    public Game findGame(int id) {

        Optional<Game> game = gameRepository.findById(id);
        return game.isPresent() ? game.get() : null;
    }

    public List<Game> findAllGames() {

        return gameRepository.findAll();
    }

    public void updateGame(Game game){

        gameRepository.save(game);
    }

    public void deleteGame(int id) {

        gameRepository.deleteById(id);
    }
    public List<Game> findByEsrbRating( String esrb){
        return gameRepository.findByEsrbRating(esrb);
    }
    public List<Game> findByStudio(String studio){
        return gameRepository.findByStudio(studio);
    }
    public List<Game> findByTitle(String title){
        return gameRepository.findByTitle(title);
    }




    //
    // Invoice API
    //

    public Invoice saveInvoice(Invoice game) {

        return invoiceRepository.save(game);
    }

    public Invoice findInvoice(int id) {

        Optional<Invoice> invoice = invoiceRepository.findById(id);
        return invoice.isPresent() ? invoice.get() : null;
    }

    public List<Invoice> findAllInvoices() {

        return invoiceRepository.findAll();
    }
    public List<Invoice> findByName( String esrb){
        return invoiceRepository.findByName(esrb);
    }


    //
    // T_shirts API
    //


    public T_Shirt saveTshirt(T_Shirt tShirt) {

        return t_shirtsRepository.save(tShirt);
    }

    public T_Shirt findTShirt(int id) {

        Optional<T_Shirt> tShirt = t_shirtsRepository.findById(id);
        return tShirt.isPresent() ? tShirt.get() : null;
    }

    public List<T_Shirt> findAllTShirts() {

        return t_shirtsRepository.findAll();
    }

    public void updateTShirt(T_Shirt tShirt) {

        t_shirtsRepository.save(tShirt);
    }

    public void deleteTShirt(int id) {

        invoiceRepository.deleteById(id);
    }
    public List<T_Shirt> findByColor(String color){
        return t_shirtsRepository.findByColor(color);
    }
    public List<T_Shirt> findBySize(String size){
        return t_shirtsRepository.findBySize(size);
    }


}
