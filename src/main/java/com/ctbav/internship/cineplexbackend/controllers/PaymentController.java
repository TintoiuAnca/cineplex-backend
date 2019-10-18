package com.ctbav.internship.cineplexbackend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ctbav.internship.cineplexbackend.DTO.PaymentDTO;
import com.ctbav.internship.cineplexbackend.models.Payment;
import com.ctbav.internship.cineplexbackend.repositories.PaymentRepository;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private PaymentController(PaymentRepository repo) {
		this.paymentRepository = repo;
	}

	@GetMapping()
	public List<Payment> list() {
		return paymentRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Payment create(@RequestBody PaymentDTO paymentDto) {
		Payment payment = new Payment(paymentDto);
		paymentRepository.save(payment);
		return payment;
	}

	@GetMapping("/{id}")
	public PaymentDTO get(@PathVariable("id") long id) {
		Payment payment = paymentRepository.getOne(id);
		PaymentDTO paymentDto = new PaymentDTO(payment);
		return paymentDto;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.paymentRepository.deleteById(Long.parseLong(id));
	}

}
