package com.potatorestaurant.single.api.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.potatorestaurant.single.api.dto.InvoiceResponse;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	@GetMapping
	public List<InvoiceResponse> listAll() {
		return Collections.emptyList();
	}

	@PostMapping
	public InvoiceResponse addInvoice() {
		return new InvoiceResponse();
	}

	@PatchMapping("/{id}")
	public InvoiceResponse editInvoice() {
		return new InvoiceResponse();
	}

	@PostMapping("/paid/{id}")
	public InvoiceResponse payInvoice() {
		return new InvoiceResponse();
	}

}
