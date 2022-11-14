package com.potatorestaurant.single.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.potatorestaurant.single.domain.enums.CustomerTableStatusEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "customer_table")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CustomerTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	private String name;
	
	@Enumerated(EnumType.ORDINAL)
	private CustomerTableStatusEnum status;

	@CreationTimestamp
	private OffsetDateTime createdAt;

	@UpdateTimestamp
	private OffsetDateTime updatedAt;

}
