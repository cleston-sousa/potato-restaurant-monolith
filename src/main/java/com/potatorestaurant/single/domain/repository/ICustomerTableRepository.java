package com.potatorestaurant.single.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.potatorestaurant.single.domain.model.CustomerTable;

public interface ICustomerTableRepository extends JpaRepository<CustomerTable, Long> {

}
