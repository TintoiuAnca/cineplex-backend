package com.ctbav.internship.cineplexbackend.controllers;

import java.text.ParseException;
import java.util.List;
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
import com.ctbav.internship.cineplexbackend.DTO.HistoryDTO;
import com.ctbav.internship.cineplexbackend.models.History;
import com.ctbav.internship.cineplexbackend.repositories.HistoryRepository;

@RestController
@RequestMapping("/api/v1/history")
public class HistoryController {
	@Autowired
	private HistoryRepository historyRepository;

	@Autowired
	private HistoryController(HistoryRepository repo) {
		this.historyRepository = repo;
	}

	@GetMapping()
	public List<HistoryDTO> list() {
		return historyRepository.findAll().stream().map(h->{
			try {
				return new HistoryDTO(h);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public History create(@RequestBody HistoryDTO historyDto) throws ParseException {
		History history = new History(historyDto);
		historyRepository.save(history);
		return history;
	}

	@GetMapping("/{id}")
	public HistoryDTO get(@PathVariable("id") long id) throws ParseException {
		History history = historyRepository.getOne(id);
		HistoryDTO historyDto = new HistoryDTO(history);
		return historyDto;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.historyRepository.deleteById(Long.parseLong(id));
	}
}
