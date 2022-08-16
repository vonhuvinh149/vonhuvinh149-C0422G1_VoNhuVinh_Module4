package com.codegym.repository.impl;

import com.codegym.repository.IRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RepositoryService implements IRepository {


    private static Map<String, String> stringMap = new HashMap<>();

    static {
        stringMap.put("hello", "xin chào");
        stringMap.put("dog", "Con chó");
        stringMap.put("cat", "con mèo");
        stringMap.put("hi", "xin chào");
    }

    @Override
    public String english(String string) {
        String result = null;
        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            if (string.equalsIgnoreCase(entry.getKey())) {
                result = entry.getValue();
            }
        }
        return result;
    }
}
