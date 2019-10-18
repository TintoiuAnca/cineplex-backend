package com.ctbav.internship.cineplexbackend.controllers;

import java.util.List;
import javax.websocket.server.PathParam;
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
import com.ctbav.internship.cineplexbackend.DTO.SeatDTO;
import com.ctbav.internship.cineplexbackend.models.Seat;
import com.ctbav.internship.cineplexbackend.repositories.SeatRepository;

@RestController
@RequestMapping("/api/v1/seat")
public class SeatController {
	@Autowired
	private SeatRepository seatRepository;

	@Autowired
	public SeatController(SeatRepository seatRepo) {
		this.seatRepository = seatRepo;
	}

	@GetMapping
	public List<Seat> list() {
		return seatRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@PathParam("user") @RequestBody SeatDTO seatDto) {
		Seat seat = new Seat(seatDto);
		seatRepository.save(seat);
	}

	@GetMapping("/{id}")
	public SeatDTO get(@PathVariable("id") long id) {
		Seat seat = seatRepository.getOne(id);
		SeatDTO seatDto = new SeatDTO(seat);
		return seatDto;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.seatRepository.deleteById(Long.parseLong(id));
	}

}
