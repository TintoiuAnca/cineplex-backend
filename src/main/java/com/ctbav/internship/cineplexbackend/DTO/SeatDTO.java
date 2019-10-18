package com.ctbav.internship.cineplexbackend.DTO;

import com.ctbav.internship.cineplexbackend.models.Movie;
import com.ctbav.internship.cineplexbackend.models.Room;
import com.ctbav.internship.cineplexbackend.models.Seat;

public class SeatDTO {
	private Long id;
	private boolean availability;
	private Movie movies;
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

	public SeatDTO(Long id, boolean availability, Movie movies, Room rooms) {
		super();
		this.id = id;
		this.availability = availability;
		this.movies = movies;
		this.rooms = rooms;
	}

	public SeatDTO() {

	}

	public SeatDTO(Seat seat) {
		setAvailability(seat.getAvailability());
		setRooms(seat.getRooms());
		setMovies(seat.getMovies());
	}

}
