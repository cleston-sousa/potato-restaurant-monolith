package com.potatorestaurant.single.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.potatorestaurant.single.domain.model.MenuCategory;

public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {

}
