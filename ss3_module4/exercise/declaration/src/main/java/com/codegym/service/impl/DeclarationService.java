package com.codegym.service.impl;

import com.codegym.repository.IDeclarationRepository;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationService implements IDeclarationService {

    @Autowired
    private IDeclarationRepository declarationRepository;

    @Override
    public List<Integer> yearOfBirth() {
        return declarationRepository.yearOfBirth();
    }

    @Override
    public List<String> gender() {
        return declarationRepository.gender();
    }

    @Override
    public List<String> nationality() {
        return declarationRepository.nationality();
    }
}
