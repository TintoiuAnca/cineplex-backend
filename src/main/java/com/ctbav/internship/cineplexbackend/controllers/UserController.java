package com.ctbav.internship.cineplexbackend.controllers;

import java.text.ParseException;
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
import com.ctbav.internship.cineplexbackend.DTO.UserDTO;
import com.ctbav.internship.cineplexbackend.models.User;
import com.ctbav.internship.cineplexbackend.repositories.UserRepository;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepo) {
		this.userRepository = userRepo;
	}

	@GetMapping
	public List<User> list() {
		return userRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@PathParam("user") @RequestBody UserDTO userDto) throws ParseException {
		User user = new User(userDto);
		userRepository.save(user);
	}

	@GetMapping("/{id}")
	public UserDTO get(@PathVariable("id") long id) throws ParseException {
		User user = userRepository.getOne(id);
		UserDTO userDto = new UserDTO(user);
		return userDto;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.userRepository.deleteById(Long.parseLong(id));
	}
}