package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodDAO extends JpaRepository <Food, Long>{
    Optional<Food> findById(Long foodId);
}
