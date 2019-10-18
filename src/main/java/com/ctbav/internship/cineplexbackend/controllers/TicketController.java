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
import com.ctbav.internship.cineplexbackend.DTO.TicketDTO;
import com.ctbav.internship.cineplexbackend.models.Ticket;
import com.ctbav.internship.cineplexbackend.repositories.TicketRepository;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private TicketController(TicketRepository ticketRepo) {
		this.ticketRepository = ticketRepo;
	}

	@GetMapping()
	public List<Ticket> list() {
		return ticketRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Ticket create(@RequestBody TicketDTO ticketDto) {
		Ticket ticket = new Ticket(ticketDto);
		ticketRepository.save(ticket);
		return ticket;
	}

	@GetMapping("/{id}")
	public TicketDTO get(@PathVariable("id") long id) {
		Ticket ticket = ticketRepository.getOne(id);
		TicketDTO ticketDto = new TicketDTO(ticket);
		return ticketDto;

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.ticketRepository.deleteById(Long.parseLong(id));
	}

}
