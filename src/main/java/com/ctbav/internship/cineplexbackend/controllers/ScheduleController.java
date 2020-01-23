package com.ctbav.internship.cineplexbackend.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	public List<ScheduleDTO> list() throws ParseException {
		List<Schedule> schedules = new ArrayList<Schedule>();
		schedules = scheduleRepository.findAll();
		List<ScheduleDTO> list = new ArrayList<ScheduleDTO>();
		ScheduleDTO scheduleDTO;
		for (Schedule s : schedules) {
			scheduleDTO = new ScheduleDTO(s);
			list.add(scheduleDTO);

		}
		list.sort(new ComparatorSchedule());
		return list;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody ScheduleDTO scheduleDto) throws ParseException {
		Schedule schedules = new Schedule(scheduleDto);
		scheduleRepository.save(schedules);
	}

	@GetMapping("/{id}")
	public List<ScheduleDTO> get(@PathVariable("id") long id) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //get the current date
		Date date = new Date();
		String strDate = formatter.format(date);
		Date data = formatter.parse(strDate);
		System.out.println("THIS IS THE DATE:" + data);
		List<Schedule> schedules = new ArrayList<Schedule>();// operating with model object Schedule
		
		Optional<Movie> movie = movieRepository.findById(id);// find the movie using the id in the URL
		if (movie.isPresent()) {
			schedules = this.scheduleRepository.findAllByScheduledMovie(movie.get());// get all schedules for the movie
			schedules = this.scheduleRepository.findAllByDate(data); // get all schedules by current day
		}
		
		List<ScheduleDTO> list = new ArrayList<ScheduleDTO>(); // convert Schedule to ScheduleDTO
		ScheduleDTO scheduleDTO;
		for (Schedule s : schedules) {
			scheduleDTO = new ScheduleDTO(s);
			list.add(scheduleDTO);

		}
		
		System.out.println(list);
		list.sort(new ComparatorSchedule()); // sort schedules in ascending order by starting time
		
		return list;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.scheduleRepository.deleteById(Long.parseLong(id));
	}

}
