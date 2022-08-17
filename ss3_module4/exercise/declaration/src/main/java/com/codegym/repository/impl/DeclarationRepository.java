package com.codegym.repository.impl;

import com.codegym.repository.IDeclarationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeclarationRepository implements IDeclarationRepository {

    private static List<Integer> yearOfBirth ;
    private static List<String> gender ;
    private static List<String> nationality ;

    static {
        yearOfBirth = new ArrayList<>();
        gender = new ArrayList<>();
        nationality = new ArrayList<>();
        for (int i = 1900; i <= 2022; i++) {
            yearOfBirth.add(i);
        }

        gender.add("Nam");
        gender.add("Nữ");

        nationality.add("VIET NAM");
        nationality.add("KOREA");
        nationality.add("TRUNG QUOC");
        nationality.add("MYANMA");

    }

    @Override
    public List<Integer> yearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public List<String> gender() {
        return gender;
    }

    @Override
    public List<String> nationality() {
        return nationality;
    }
}
