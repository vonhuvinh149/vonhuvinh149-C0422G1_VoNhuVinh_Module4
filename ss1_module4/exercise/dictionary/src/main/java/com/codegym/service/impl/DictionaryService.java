package com.codegym.service.impl;

import com.codegym.repository.IRepository;
import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    private IRepository repository;

    @Override
    public String english(String string) {
        return repository.english(string);
    }
}
