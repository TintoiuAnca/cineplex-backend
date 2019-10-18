package com.ctbav.internship.cineplexbackend.DTO;

import com.ctbav.internship.cineplexbackend.models.History;
import com.ctbav.internship.cineplexbackend.models.Movie;
import com.ctbav.internship.cineplexbackend.models.Reservation;
import com.ctbav.internship.cineplexbackend.models.User;

public class ReservationDTO {
	private Long id;
	private String seat;
	private String code;
	private History history;
	private User userRes;
	private Movie reservationMovie;

	public Movie getReservationMovie() {
		return reservationMovie;
	}

	public void setReservationMovie(Movie reservationMovie) {
		this.reservationMovie = reservationMovie;
	}

	public Long getId() {
		return id;
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

	public ReservationDTO(Long id, String seat, String code, History history, User userRes, Movie reservationMovie) {
		this.id = id;
		this.seat = seat;
		this.code = code;
		this.history = history;
		this.userRes = userRes;
		this.reservationMovie = reservationMovie;
	}

	public ReservationDTO() {
	}

	public ReservationDTO(Reservation reservation) {
		setCode(reservation.getCode());
		setSeat(reservation.getSeat());
		setHistory(reservation.getHistory());
		setReservationMovie(reservation.getReservationMovie());
		setUserRes(reservation.getUserRes());
	}

	@Override
	public String toString() {
		return "ReservationDTO [id=" + id + ", seat=" + seat + ", code=" + code + ", history=" + history + ", userRes="
				+ userRes + ", reservationMovie=" + reservationMovie + "]";
	}

}
