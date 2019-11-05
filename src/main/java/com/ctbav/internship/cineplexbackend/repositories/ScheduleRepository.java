package com.ctbav.internship.cineplexbackend.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ctbav.internship.cineplexbackend.models.Movie;
import com.ctbav.internship.cineplexbackend.models.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	List<Schedule> findAllByScheduledMovie(Movie movie);

}
