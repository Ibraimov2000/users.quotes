package com.users.quotes.controller;

import com.users.quotes.entity.Quote;
import com.users.quotes.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/quotes")
    public ResponseEntity<List<Quote>> getQuotes() {
        List<Quote> quotes = quoteService.getAll();
        return new ResponseEntity<>(quotes.stream().limit(10).sorted().toList(), HttpStatus.OK);
    }

    @GetMapping("/quote/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable Long id) {
        Quote quote = quoteService.getById(id);
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @PutMapping("/updateQuote/{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable Long id, @RequestBody Quote quote) {
        Quote quote1 = quoteService.getById(id);
        quote1.setStatement(quote.getStatement());
        quote1.setUser(quote.getUser());
        quote1.setVote(quote.getVote());
        Quote quote2 = quoteService.save(quote1);
        return new ResponseEntity<>(quote2, HttpStatus.OK);
    }

    @PutMapping("/quote/{id}/{var}")
    public ResponseEntity<Quote> putVote(@PathVariable Long id, @PathVariable String var) {
        Quote quote = quoteService.getById(id);
        if(var.equals("+")) {
            quote.setVote(quote.getVote() + 1);
        } else {
            quote.setVote(quote.getVote() - 1);
        }
        Quote quote1 = quoteService.save(quote);
        return new ResponseEntity<>(quote1, HttpStatus.OK);
    }

    @PostMapping("/createQuote")
    public ResponseEntity<Quote> createQuote(Quote quote) {
        Quote quote1 = quoteService.save(quote);
        return new ResponseEntity<>(quote1, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Quote> deleteById(@PathVariable Long id) {
        quoteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
