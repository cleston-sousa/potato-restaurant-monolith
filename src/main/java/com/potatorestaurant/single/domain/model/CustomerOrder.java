package com.potatorestaurant.single.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.potatorestaurant.single.domain.enums.CustomerOrderStatusEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne
	private CustomerTable customerTable;

	@ManyToOne
	private MenuItem menuItem;

	private Integer quantity;

	@Enumerated(EnumType.ORDINAL)
	private CustomerOrderStatusEnum status;

}
