package com.ctbav.internship.cineplexbackend.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.ctbav.internship.cineplexbackend.DTO.PaymentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double finalPrice;
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "payer", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User payer;

	@OneToMany(mappedBy = "payment")
	@JsonIgnore
	private List<Ticket> tickets;

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

	public Payment(Long id, double finalPrice, boolean status, User payer) {
		this.id = id;
		this.finalPrice = finalPrice;
		this.status = status;
		this.payer = payer;
	}

	public Payment() {
	}

	public Payment(PaymentDTO paymentDto) {
		setFinalPrice(paymentDto.getFinalPrice());
		setStatus(paymentDto.getStatus());
		setPayer(paymentDto.getPayer());

	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", final_price=" + finalPrice + ", status=" + status + ", payer=" + payer + "]";
	}

}
