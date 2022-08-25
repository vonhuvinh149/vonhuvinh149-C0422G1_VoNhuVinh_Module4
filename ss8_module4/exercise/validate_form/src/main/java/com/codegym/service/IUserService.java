package com.codegym.service;

import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    Page<User> findAll(Pageable pageable);

    Page<User> findByEmailContaining(String email, Pageable pageable);

    void save(User users);
}
