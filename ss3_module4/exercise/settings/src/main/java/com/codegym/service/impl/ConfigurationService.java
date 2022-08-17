package com.codegym.service.impl;

import com.codegym.repository.IConfigurationRepository;
import com.codegym.service.IConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService implements IConfigurationService {

    @Autowired
    private IConfigurationRepository configurationRepository;

    @Override
    public List<String> languages() {
        return configurationRepository.languages();
    }

    @Override
    public List<Integer> pageSize() {
        return configurationRepository.pageSize();
    }

}
