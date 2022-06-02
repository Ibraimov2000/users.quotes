package com.users.quotes.service;

import com.users.quotes.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);
    User getById(Long id);
    List<User> getAll();
    void deleteById(Long id);
}
