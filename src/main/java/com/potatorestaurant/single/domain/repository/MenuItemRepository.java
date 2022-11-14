package com.potatorestaurant.single.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.potatorestaurant.single.domain.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}
