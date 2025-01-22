package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.StoreItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDAO extends JpaRepository<StoreItem, Long> {
}
