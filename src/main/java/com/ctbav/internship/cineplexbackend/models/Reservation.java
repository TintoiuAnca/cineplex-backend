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
import com.ctbav.internship.cineplexbackend.DTO.ReservationDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String seat;
	private String code;

	@ManyToOne
	@JoinColumn(name = "history", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private History history;

	@ManyToOne
	@JoinColumn(name = "userRes", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User userRes;

	@ManyToOne
	@JoinColumn(name = "reservationMovie", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Movie reservationMovie;

	@OneToMany(mappedBy = "reservation")
	@JsonIgnore
	private List<Ticket> tickets;

	public Reservation(ReservationDTO reservationDto) {
		setCode(reservationDto.getCode());
		setSeat(reservationDto.getSeat());
		setHistory(reservationDto.getHistory());
		setReservationMovie(reservationDto.getReservationMovie());
		setUserRes(reservationDto.getUserRes());
	}

	public Movie getReservationMovie() {
		return reservationMovie;
	}

	public void setReservationMovie(Movie reservationMovie) {
		this.reservationMovie = reservationMovie;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Long getId() {
		return id;
	}

	public Reservation() {
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", seat=" + seat + ", code=" + code + ", history=" + history + ", userRes="
				+ userRes + "]";
	}

	public Reservation(Long id, String seat, String code, History history, User userRes) {
		this.id = id;
		this.seat = seat;
		this.code = code;
		this.history = history;
		this.userRes = userRes;
	}

	public Reservation(Object object, Object object2, String code2, Object object3) {
		this.code = code2;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public User getUserRes() {
		return userRes;
	}

	public void setUserRes(User userRes) {
		this.userRes = userRes;
	}

}
