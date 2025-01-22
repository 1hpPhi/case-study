package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    User findByEmailIgnoreCase(String email);
}