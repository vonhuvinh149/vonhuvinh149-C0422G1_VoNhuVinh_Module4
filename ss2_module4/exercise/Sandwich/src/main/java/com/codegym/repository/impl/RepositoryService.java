package com.codegym.repository.impl;

import com.codegym.repository.IRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepositoryService implements IRepository {

    private static List<String> stringList = new ArrayList<>();

    static {
        stringList.add("Lettuce");
        stringList.add("Tomato");
        stringList.add("Mustard");
        stringList.add("Sprouts");
    }

    @Override
    public List<String> findAll() {
        return stringList;
    }
}
