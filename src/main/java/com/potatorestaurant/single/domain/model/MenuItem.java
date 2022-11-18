package com.potatorestaurant.single.domain.model;

import java.math.BigDecimal;
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

import com.potatorestaurant.single.domain.enums.MenuItemStatusEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private MenuCategory menuCategory;

	private String name;

	private String description;

	@Enumerated(EnumType.ORDINAL)
	private MenuItemStatusEnum status;

	private BigDecimal price;

	@CreationTimestamp
	private OffsetDateTime createdAt;

	@UpdateTimestamp
	private OffsetDateTime updatedAt;

	@OneToMany(mappedBy = "menuItem", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Ingredient> ingredients = new ArrayList<>();

}
