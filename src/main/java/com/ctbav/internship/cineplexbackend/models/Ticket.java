package com.ctbav.internship.cineplexbackend.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.ctbav.internship.cineplexbackend.DTO.TicketDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double price;
	private int ticketCode;
	private TicketType type;

	@ManyToOne
	@JoinColumn(name = "reservation", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Reservation reservation;

	@ManyToOne
	@JoinColumn(name = "schedule", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Schedule schedule;

	@ManyToOne
	@JoinColumn(name = "payment", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Payment payment;

	public Ticket() {

	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Ticket(TicketDTO ticketDto) {
		setPrice(ticketDto.getPrice());
		setTicketCode(ticketDto.getTicketCode());
		setType(ticketDto.getType());
		setPayment(ticketDto.getPayment());
		setReservation(ticketDto.getReservation());
		setSchedule(ticketDto.getSchedule());
	}

	public Ticket(Long id, double price, int ticketCode, TicketType type) {

		this.id = id;
		this.price = price;
		this.ticketCode = ticketCode;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", price=" + price + ", ticketCode=" + ticketCode + ", type=" + type + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTicketCode() {
		return ticketCode;
	}

	public void setTicketCode(int ticketCode) {
		this.ticketCode = ticketCode;
	}

	@Enumerated(EnumType.STRING)
	public TicketType getType() {
		return type;
	}

	public void setType(TicketType type) {
		this.type = type;
	}

}
