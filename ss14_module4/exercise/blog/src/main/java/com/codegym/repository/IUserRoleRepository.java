package com.codegym.repository;

import com.codegym.model.AppUser;
import com.codegym.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole , Integer> {
    List<UserRole> findAllByAppUser(AppUser appUser);
}
