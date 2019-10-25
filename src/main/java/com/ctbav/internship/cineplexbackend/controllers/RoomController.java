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

import com.ctbav.internship.cineplexbackend.DTO.RoomDTO;
import com.ctbav.internship.cineplexbackend.models.Room;
import com.ctbav.internship.cineplexbackend.repositories.RoomRepository;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private RoomController(RoomRepository repo) {
		this.roomRepository = repo;
	}

	@GetMapping()
	public List<Room> list() {
		return roomRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Room create(@RequestBody RoomDTO roomDto) {
		Room room = new Room(roomDto);
		roomRepository.save(room);
		return room;
	}

	@GetMapping("/{id}")
	public RoomDTO get(@PathVariable("id") long id) {
		Room room = roomRepository.getOne(id);
		RoomDTO roomDto = new RoomDTO(room);
		return roomDto;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.roomRepository.deleteById(Long.parseLong(id));
	}
}
