package com.springmvc.service.impl;

import com.springmvc.repository.IRepository;
import com.springmvc.service.IMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyService implements IMoneyService {

    @Autowired
    private IRepository repository;

    @Override
    public double money(double a) {
        return repository.money(a);
    }
}
