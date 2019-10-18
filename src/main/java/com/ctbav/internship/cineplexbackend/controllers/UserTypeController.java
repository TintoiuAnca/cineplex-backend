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
import com.ctbav.internship.cineplexbackend.DTO.UserTypeDTO;
import com.ctbav.internship.cineplexbackend.models.UserType;
import com.ctbav.internship.cineplexbackend.repositories.UserTypeRepository;

@RestController
@RequestMapping("/api/v1/usertype")
public class UserTypeController {
	@Autowired
	private UserTypeRepository userTypeRepository;

	@GetMapping
	public List<UserType> list() {
		return userTypeRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody UserType userType) {
		userTypeRepository.save(userType);
	}

	@GetMapping("/{id}")
	public UserTypeDTO get(@PathVariable("id") long id) {
		UserType userType = userTypeRepository.getOne(id);
		UserTypeDTO userTypeDto = new UserTypeDTO(userType);
		return userTypeDto;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.userTypeRepository.deleteById(Long.parseLong(id));
	}

}
