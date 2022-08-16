package com.springmvc.repository.impl;

import com.springmvc.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryService implements IRepository {
    @Override
    public double money(double a) {
        return a * 23000;
    }
}
