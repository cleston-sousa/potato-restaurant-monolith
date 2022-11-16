package com.potatorestaurant.single.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.potatorestaurant.single.domain.model.CustomerOrder;

public interface ICustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

}
