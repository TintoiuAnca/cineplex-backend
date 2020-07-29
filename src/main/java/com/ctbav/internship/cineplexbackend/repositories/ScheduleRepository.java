package com.ctbav.internship.cineplexbackend.repositories;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ctbav.internship.cineplexbackend.models.Movie;
import com.ctbav.internship.cineplexbackend.models.Room;
import com.ctbav.internship.cineplexbackend.models.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	List<Schedule> findAllByScheduledMovie(Optional<Movie> movie);
	List<Schedule> findAllByDate(Date date);
}
