package com.users.quotes.service;

import com.users.quotes.entity.Quote;

import java.util.List;

public interface QuoteService {

    Quote save(Quote quote);
    Quote getById(Long id);
    List<Quote> getAll();
    void deleteById(Long id);
}
