package com.potatorestaurant.single.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.potatorestaurant.single.domain.enums.MenuItemStatusEnum;
import com.potatorestaurant.single.domain.model.MenuItem;

public interface IMenuItemRepository extends JpaRepository<MenuItem, Long> {

	List<MenuItem> findAllByStatus(MenuItemStatusEnum status);
}
