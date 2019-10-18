package com.ctbav.internship.cineplexbackend.DTO;

import com.ctbav.internship.cineplexbackend.models.Payment;
import com.ctbav.internship.cineplexbackend.models.Reservation;
import com.ctbav.internship.cineplexbackend.models.Schedule;
import com.ctbav.internship.cineplexbackend.models.Ticket;
import com.ctbav.internship.cineplexbackend.models.TicketType;

public class TicketDTO {
	private Long id;
	private double price;
	private int ticketCode;
	private TicketType type;
	private Reservation reservation;
	private Schedule schedule;
	private Payment payment;

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

	public TicketType getType() {
		return type;
	}

	public void setType(TicketType type) {
		this.type = type;
	}

	public TicketDTO(Long id, double price, int ticketCode, TicketType type, Reservation reservation, Schedule schedule,
			Payment payment) {
		super();
		this.id = id;
		this.price = price;
		this.ticketCode = ticketCode;
		this.type = type;
		this.reservation = reservation;
		this.schedule = schedule;
		this.payment = payment;
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

	public TicketDTO() {
		super();
	}

	public TicketDTO(Ticket ticket) {
		setPrice(ticket.getPrice());
		setTicketCode(ticket.getTicketCode());
		setType(ticket.getType());
		setPayment(ticket.getPayment());
		setReservation(ticket.getReservation());
		setSchedule(ticket.getSchedule());
	}

	@Override
	public String toString() {
		return "TicketDTO [id=" + id + ", price=" + price + ", ticketCode=" + ticketCode + ", type=" + type
				+ ", reservation=" + reservation + ", schedule=" + schedule + ", payment=" + payment + "]";
	}

}
