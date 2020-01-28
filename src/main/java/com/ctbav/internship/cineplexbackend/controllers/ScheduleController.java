package com.ctbav.internship.cineplexbackend.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
	public List<ScheduleDTO> list() throws ParseException {
		ComparatorSchedule comparatorSchedule = new ComparatorSchedule();
		return scheduleRepository.findAll().stream().sorted(comparatorSchedule::compare).map(t -> {
			try {
				return new ScheduleDTO(t);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Schedule create(@RequestBody ScheduleDTO scheduleDto) throws ParseException {
		Schedule schedule = new Schedule(scheduleDto);
		scheduleRepository.save(schedule);
		return schedule;
	}

	@GetMapping("/{id}")
	public List<ScheduleDTO> getScheduleByMovie(@PathVariable("id") long id) throws ParseException {
		Optional<Movie> movie = movieRepository.findById(id);// find the movie using the id in the URL
		ComparatorSchedule comparatorSchedule = new ComparatorSchedule();
		return scheduleRepository.findAllByScheduledMovie(movie.get()).stream().sorted(comparatorSchedule::compare)
				.map(t -> {
					try {
						return new ScheduleDTO(t);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return null;
				}).collect(Collectors.toList());
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //get the current date
//		Date date = new Date();
//		String strDate = formatter.format(date);
//		Date data = formatter.parse(strDate);
//		System.out.println("THIS IS THE DATE:" + data);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.scheduleRepository.deleteById(Long.parseLong(id));
	}

}
