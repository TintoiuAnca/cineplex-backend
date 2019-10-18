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
import com.ctbav.internship.cineplexbackend.DTO.StatisticDTO;
import com.ctbav.internship.cineplexbackend.models.Statistic;
import com.ctbav.internship.cineplexbackend.repositories.StatisticRepository;

@RestController
@RequestMapping("/api/v1/statistic")
public class StatisticController {
	@Autowired
	private StatisticRepository statisticRepository;

	@Autowired
	private StatisticController(StatisticRepository repo) {
		this.statisticRepository = repo;
	}

	@GetMapping()
	public List<Statistic> list() {
		return statisticRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Statistic create(@RequestBody StatisticDTO statisticDto) throws ParseException {
		Statistic statistic = new Statistic(statisticDto);
		statisticRepository.save(statistic);
		return statistic;

	}

	@GetMapping("/{id}")
	public StatisticDTO get(@PathVariable("id") long id) throws ParseException {
		Statistic statistic = statisticRepository.getOne(id);
		StatisticDTO statisticDto = new StatisticDTO(statistic);
		return statisticDto;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.statisticRepository.deleteById(Long.parseLong(id));
	}

}
