package com.codegym.service.impl;

import com.codegym.repository.IRepository;
import com.codegym.service.ISandwich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichService implements ISandwich {

    @Autowired
    private IRepository repository;

    @Override
    public List<String> findAll() {
        return repository.findAll();
    }
}
