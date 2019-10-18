package com.ctbav.internship.cineplexbackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.ctbav.internship.cineplexbackend.DTO.SeatDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean availability;

	@ManyToOne
	@JoinColumn(name = "movies", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Movie movies;

	@ManyToOne
	@JoinColumn(name = "rooms", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Room rooms;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean getAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Movie getMovies() {
		return movies;
	}

	public void setMovies(Movie movies) {
		this.movies = movies;
	}

	public Room getRooms() {
		return rooms;
	}

	public void setRooms(Room rooms) {
		this.rooms = rooms;
	}

	public Seat(Long id, boolean availability, Movie movies, Room rooms) {
		this.id = id;
		this.availability = availability;
		this.movies = movies;
		this.rooms = rooms;
	}

	public Seat() {
	}

	public Seat(SeatDTO seatDto) {
		setAvailability(seatDto.getAvailability());
		setRooms(seatDto.getRooms());
		setMovies(seatDto.getMovies());
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", availability=" + availability + ", movies=" + movies + ", rooms=" + rooms + "]";
	}

}
