package com.users.quotes.service;

import com.users.quotes.entity.Quote;
import com.users.quotes.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public Quote save(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public Quote getById(Long id) {
        return quoteRepository.findById(id).get();
    }

    @Override
    public List<Quote> getAll() {
        return quoteRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        quoteRepository.deleteById(id);
    }
}
