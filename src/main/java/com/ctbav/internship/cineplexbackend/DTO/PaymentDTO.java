package com.ctbav.internship.cineplexbackend.DTO;

import com.ctbav.internship.cineplexbackend.models.Payment;
import com.ctbav.internship.cineplexbackend.models.User;

public class PaymentDTO {
	private Long id;
	private double finalPrice;
	private boolean status;
	private User payer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public User getPayer() {
		return payer;
	}

	public void setPayer(User payer) {
		this.payer = payer;
	}

	public PaymentDTO(Long id, double finalPrice, boolean status, User payer) {

		this.id = id;
		this.finalPrice = finalPrice;
		this.status = status;
		this.payer = payer;
	}

	public PaymentDTO() {

	}

	public PaymentDTO(Payment payment) {
		setFinalPrice(payment.getFinalPrice());
		setStatus(payment.getStatus());
		setPayer(payment.getPayer());
	}

	@Override
	public String toString() {
		return "PaymentDTO [id=" + id + ", finalPrice=" + finalPrice + ", status=" + status + ", payer=" + payer + "]";
	}

}
