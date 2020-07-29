package com.ctbav.internship.cineplexbackend.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ctbav.internship.cineplexbackend.DTO.SeatDTO;
import com.ctbav.internship.cineplexbackend.models.Movie;
import com.ctbav.internship.cineplexbackend.models.Room;
import com.ctbav.internship.cineplexbackend.models.Schedule;
import com.ctbav.internship.cineplexbackend.models.Seat;
import com.ctbav.internship.cineplexbackend.repositories.MovieRepository;
import com.ctbav.internship.cineplexbackend.repositories.RoomRepository;
import com.ctbav.internship.cineplexbackend.repositories.ScheduleRepository;
import com.ctbav.internship.cineplexbackend.repositories.SeatRepository;

@RestController
@RequestMapping("/api/v1/seat")
public class SeatController {
  @Autowired
  private SeatRepository seatRepository;

  @Autowired
  private MovieRepository movieRepository;
  
  @Autowired
  private RoomRepository roomRepository;

  @Autowired
  public SeatController(SeatRepository seatRepo, MovieRepository movieRepo) {
    this.seatRepository = seatRepo;
    this.movieRepository = movieRepo;
  }

  @GetMapping
  public List<SeatDTO> list() {
    return seatRepository.findAll().stream().map(s -> new SeatDTO(s)).collect(Collectors.toList());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public Seat create(@RequestBody SeatDTO seatDto) {
    Seat seat = new Seat(seatDto);
    seatRepository.save(seat);
    return seat;
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public List<SeatDTO> getAllSeatsByMovie(@PathVariable("id") long id, @RequestParam("room") String roomName) {
    List<Seat> seats = new ArrayList<Seat>();
    Optional<Movie> movie = movieRepository.findById(id);
    Room room=roomRepository.findByRoomName(roomName);
    if (movie.isPresent())
      seats = this.seatRepository.findAllByMoviesAndRooms(movie, room);
    List<SeatDTO> seatsDTO = new ArrayList<SeatDTO>();
    for (Seat s : seats) {
      SeatDTO seatDTO = new SeatDTO(s);
      seatsDTO.add(seatDTO);
      // seatsDTO = seats.stream().map(st -> new SeatDTO(s)).collect(Collectors.toList());
    }
    return seatsDTO.stream().collect(Collectors.toList());
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    this.seatRepository.deleteById(Long.parseLong(id));
  }

}
