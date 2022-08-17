package com.codegym.repository.impl;

import com.codegym.repository.IConfigurationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConfigurationRepository implements IConfigurationRepository {

    private static List<String> languagesList;
    private static List<Integer> pageSizeList;

    static {
        languagesList = new ArrayList<>();
        pageSizeList = new ArrayList<>();

        languagesList.add("English");
        languagesList.add("Tiếng Việt");
        languagesList.add("Tiếng Trung");

        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(75);
        pageSizeList.add(100);
    }

    @Override
    public List<String> languages() {
        return languagesList;
    }

    @Override
    public List<Integer> pageSize() {
        return pageSizeList;
    }

}
