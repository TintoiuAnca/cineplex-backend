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
import com.ctbav.internship.cineplexbackend.DTO.UserDTO;
import com.ctbav.internship.cineplexbackend.models.User;
import com.ctbav.internship.cineplexbackend.models.UserType;
import com.ctbav.internship.cineplexbackend.repositories.UserRepository;
import com.ctbav.internship.cineplexbackend.repositories.UserTypeRepository;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserTypeRepository userTypeRepository;

  @Autowired
  public UserController(UserRepository userRepo, UserTypeRepository userTypeRepository) {
    this.userRepository = userRepo;
    this.userTypeRepository = userTypeRepository;
  }

  @GetMapping
  public List<UserDTO> list() {
    return userRepository.findAll().stream().map(u -> {
      try {
        return new UserDTO(u);
      } catch (ParseException e) {
        e.printStackTrace();
      }
      return null;
    }).collect(Collectors.toList());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public User create(@RequestBody UserDTO userDto) throws ParseException {
    UserType userType =
        userTypeRepository.findByTypeName(userDto.getUserType().getTypeName()).get();
    User user = new User(userDto);
    user.setUserType(userType);
    userRepository.save(user);
    return user;
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
