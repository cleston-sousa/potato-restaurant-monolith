package com.potatorestaurant.single.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.potatorestaurant.single.domain.model.CustomerTable;

public interface CustomerTableRepository extends JpaRepository<CustomerTable, Long> {

}
