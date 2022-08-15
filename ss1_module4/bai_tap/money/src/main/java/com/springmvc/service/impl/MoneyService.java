package com.springmvc.service.impl;

import com.springmvc.service.IMoneyService;
import org.springframework.stereotype.Service;

@Service
public class MoneyService implements IMoneyService {
    @Override
    public double money(double a) {
        return a * 23000;
    }
}
