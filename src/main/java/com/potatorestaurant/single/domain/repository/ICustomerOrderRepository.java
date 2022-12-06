package com.potatorestaurant.single.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.potatorestaurant.single.domain.enums.CustomerOrderStatusEnum;
import com.potatorestaurant.single.domain.model.CustomerOrder;

public interface ICustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

	@Query("from CustomerOrder co left join fetch co.customIngredient where co.id = :id")
	Optional<CustomerOrder> findById(Long id);

	List<CustomerOrder> findAllByStatus(CustomerOrderStatusEnum status);

}
