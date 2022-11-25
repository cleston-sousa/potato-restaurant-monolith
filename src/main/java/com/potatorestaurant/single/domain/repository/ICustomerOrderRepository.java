package com.potatorestaurant.single.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.potatorestaurant.single.domain.enums.CustomerOrderStatusEnum;
import com.potatorestaurant.single.domain.model.CustomerOrder;

public interface ICustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

	List<CustomerOrder> findAllByStatus(CustomerOrderStatusEnum status);

	List<CustomerOrder> findAllByCustomerTableId(Long customerTableId);

	List<CustomerOrder> findAllByStatusAndCustomerTableId(CustomerOrderStatusEnum status, Long customerTableId);

}
