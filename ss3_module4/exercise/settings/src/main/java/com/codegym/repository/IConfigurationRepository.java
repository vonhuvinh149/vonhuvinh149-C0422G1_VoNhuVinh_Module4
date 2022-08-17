package com.codegym.repository;

import java.util.List;

public interface IConfigurationRepository {
    List<String> languages();

    List<Integer> pageSize();

}
