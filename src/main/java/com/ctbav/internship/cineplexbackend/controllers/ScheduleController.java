package com.ctbav.internship.cineplexbackend.controllers;

import java.text.ParseException;
import java.util.List;
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
import com.ctbav.internship.cineplexbackend.models.Schedule;
import com.ctbav.internship.cineplexbackend.repositories.ScheduleRepository;

@RestController
@RequestMapping("/api/v1/schedule")
public class ScheduleController {
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	public ScheduleController(ScheduleRepository scheduleRepo) {
		this.scheduleRepository = scheduleRepo;
	}

	@GetMapping
	public List<Schedule> list() {
		return scheduleRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody ScheduleDTO scheduleDto) throws ParseException {
		Schedule schedule = new Schedule(scheduleDto);
		scheduleRepository.save(schedule);
	}

	@GetMapping("/{id}")
	public ScheduleDTO get(@PathVariable("id") long id) throws ParseException {
		Schedule schedule = scheduleRepository.getOne(id);
		ScheduleDTO scheduleDto = new ScheduleDTO(schedule);
		return scheduleDto;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.scheduleRepository.deleteById(Long.parseLong(id));
	}

}
