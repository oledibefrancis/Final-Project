package com.company.gamestore.service;

import com.company.gamestore.model.*;
import com.company.gamestore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
@ComponentScan("com.company.gamestore.repository")
public class ServiceLayer {
    private ConsoleRepository consoleRepository;
    private GameRepository gameRepository;
    private InvoiceRepository invoiceRepository;
    private T_shirtsRepository t_shirtsRepository;
    private FeeRepository feeRepository;
    private TaxRepository taxRepository;

    @Autowired
    public ServiceLayer(ConsoleRepository consoleRepository, GameRepository gameRepository, InvoiceRepository invoiceRepository, T_shirtsRepository t_shirtsRepository, FeeRepository feeRepository, TaxRepository taxRepository) {
        this.consoleRepository = consoleRepository;
        this.gameRepository = gameRepository;
        this.invoiceRepository = invoiceRepository;
        this.t_shirtsRepository = t_shirtsRepository;
        this.feeRepository = feeRepository;
        this.taxRepository = taxRepository;
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

    public Invoice saveInvoice(Invoice invoice) {
        // Starter tests
        if (invoice.getQuantity() < 0) {
            return invoiceRepository.save(invoice);
        }

        // First get the subtotal and the processing fee
        BigDecimal subTotal = BigDecimal.valueOf(0);

        if (invoice.getItem_type().equals("Game")) {
            Optional<Game> game = gameRepository.findById(invoice.getItem_id());

            if (game.isPresent() && (invoice.getQuantity() <= game.get().getQuantity())) {
                subTotal = game.get().getPrice().multiply(BigDecimal.valueOf(invoice.getQuantity()));
                invoice.setUnit_price(game.get().getPrice());
            } else {
                return invoiceRepository.save(invoice);
            }

            invoice.setProcessing_fee(BigDecimal.valueOf(1.49));
        } else if (invoice.getItem_type().equals("Console")) {
            Optional<Console> console = consoleRepository.findById(invoice.getItem_id());

            if (console.isPresent() && (invoice.getQuantity() <= console.get().getQuantity())) {
                subTotal = console.get().getPrice().multiply(BigDecimal.valueOf(invoice.getQuantity()));
                invoice.setUnit_price(console.get().getPrice());
            } else {
                return invoiceRepository.save(invoice);
            }

            invoice.setProcessing_fee(BigDecimal.valueOf(14.99));
        } else if (invoice.getItem_type().equals("T-Shirt")) {
            Optional<T_Shirt> tShirt = t_shirtsRepository.findById(invoice.getItem_id());

            if (tShirt.isPresent() && (invoice.getQuantity() <= tShirt.get().getQuantity())) {
                subTotal = tShirt.get().getPrice().multiply(BigDecimal.valueOf(invoice.getQuantity()));
                invoice.setUnit_price(tShirt.get().getPrice());
            } else {
                return invoiceRepository.save(invoice);
            }

            invoice.setProcessing_fee(BigDecimal.valueOf(1.98));
        } else {
            return invoiceRepository.save(invoice);
        }

        invoice.setSubtotal(subTotal);

        // Next get the tax
        Tax tax = taxRepository.findByState(invoice.getState());
        invoice.setTax(tax.getRate().multiply(subTotal));
        // Check for additional processing fee
        if (invoice.getQuantity() > 10) {
            invoice.setProcessing_fee(invoice.getProcessing_fee().add(BigDecimal.valueOf(15.49)));
        }

        // Finally, get the total
        BigDecimal total = invoice.getSubtotal().add(invoice.getTax()).add(invoice.getProcessing_fee());
        invoice.setTotal(total);

        return invoiceRepository.save(invoice);
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
