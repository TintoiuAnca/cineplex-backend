package com.ctbav.internship.cineplexbackend.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ctbav.internship.cineplexbackend.DTO.ScheduleDTO;
import com.ctbav.internship.cineplexbackend.models.Movie;
import com.ctbav.internship.cineplexbackend.models.Schedule;
import com.ctbav.internship.cineplexbackend.repositories.MovieRepository;
import com.ctbav.internship.cineplexbackend.repositories.ScheduleRepository;
import com.ctbav.internship.cineplexbackend.util.ComparatorSchedule;

@RestController
@RequestMapping("/api/v1/schedule")
public class ScheduleController {
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	public ScheduleController(ScheduleRepository scheduleRepo, MovieRepository movieRepo) {
		this.scheduleRepository = scheduleRepo;
		this.movieRepository = movieRepo;
	}

	@GetMapping
	public List<Schedule> list() {
	//	scheduleRepository.findAll().sort(new ComparatorSchedule());
		return scheduleRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody ScheduleDTO scheduleDto) throws ParseException {
		Schedule schedules = new Schedule(scheduleDto);
		scheduleRepository.save(schedules);
	}

	@GetMapping("/{id}")
	public List<Schedule> get(@PathVariable("id") long id) throws ParseException {
		List<Schedule> schedules = new ArrayList<>();
		Optional<Movie> movie = movieRepository.findById(id);
		if (movie.isPresent()) {
			schedules = this.scheduleRepository.findAllByScheduledMovie(movie.get());
		}
		return schedules;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.scheduleRepository.deleteById(Long.parseLong(id));
	}

}
