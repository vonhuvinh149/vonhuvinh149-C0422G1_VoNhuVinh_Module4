package com.codegym.repository;

import com.codegym.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser,Integer> {
           AppUser findAllByUserName(String user);
}
