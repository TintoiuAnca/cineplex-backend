package com.ctbav.internship.cineplexbackend.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ctbav.internship.cineplexbackend.models.Movie;
import com.ctbav.internship.cineplexbackend.models.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
	List<Seat> findAllByMovies(Optional<Movie> movie);

}
