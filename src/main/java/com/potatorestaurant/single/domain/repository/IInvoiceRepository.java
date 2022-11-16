package com.potatorestaurant.single.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.potatorestaurant.single.domain.model.Invoice;

public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {

}
