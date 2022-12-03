package com.potatorestaurant.single.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

	@ManyToOne(fetch = FetchType.LAZY)
	private CustomerTable customerTable;

	@ManyToOne(fetch = FetchType.LAZY)
	private MenuItem menuItem;

	private Integer quantity;

	@Enumerated(EnumType.ORDINAL)
	private CustomerOrderStatusEnum status;

	@CreationTimestamp
	private OffsetDateTime createdAt;

	@UpdateTimestamp
	private OffsetDateTime updatedAt;

	@OneToMany(mappedBy = "ingredientId.customerOrder", cascade = CascadeType.ALL)
	List<AddIngredient> addIngredient = new ArrayList<>();

	@OneToMany(mappedBy = "ingredientId.customerOrder", cascade = CascadeType.ALL)
	List<RemoveIngredient> removeIngredient = new ArrayList<>();

}
