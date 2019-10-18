package com.ctbav.internship.cineplexbackend.controllers;

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
import com.ctbav.internship.cineplexbackend.DTO.ReservationDTO;
import com.ctbav.internship.cineplexbackend.models.Reservation;
import com.ctbav.internship.cineplexbackend.repositories.ReservationRepository;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private ReservationController(ReservationRepository repo) {
		this.reservationRepository = repo;
	}

	@GetMapping()
	public List<Reservation> list() {
		return reservationRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Reservation create(@RequestBody ReservationDTO reservationDto) {
		Reservation reservation = new Reservation(reservationDto);
		reservationRepository.save(reservation);
		return reservation;
	}

	@GetMapping("/{id}")
	public ReservationDTO get(@PathVariable("id") long id) {
		Reservation reservation = reservationRepository.getOne(id);
		ReservationDTO reservationDto = new ReservationDTO(reservation);
		return reservationDto;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.reservationRepository.deleteById(Long.parseLong(id));
	}
}
