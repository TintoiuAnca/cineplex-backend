package com.ctbav.internship.cineplexbackend.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;
import java.util.stream.Collectors;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
import com.ctbav.internship.cineplexbackend.DTO.ScheduleDTO;
import com.ctbav.internship.cineplexbackend.models.Movie;
import com.ctbav.internship.cineplexbackend.models.Schedule;
import com.ctbav.internship.cineplexbackend.repositories.MovieRepository;
import com.ctbav.internship.cineplexbackend.repositories.ScheduleRepository;
import com.ctbav.internship.cineplexbackend.util.ComparatorSchedule;

@RestController
@RequestMapping("/api/v1/schedule")
public class ScheduleController {
  private static final Date CurrentDate = new Date();
  private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
  private static final String stringCurrentDate=formatter.format(CurrentDate);
  private static final ComparatorSchedule comparatorSchedule = new ComparatorSchedule();
  
  @Autowired
  private ScheduleRepository scheduleRepository;

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  public ScheduleController(ScheduleRepository scheduleRepo, MovieRepository movieRepo) {
    this.scheduleRepository = scheduleRepo;
    this.movieRepository = movieRepo;
  }

//  @GetMapping
//  public List<ScheduleDTO> list() throws ParseException {
//    ComparatorSchedule comparatorSchedule = new ComparatorSchedule();
//    return scheduleRepository.findAll().stream().sorted(comparatorSchedule::compare).map(t -> {
//      try {
//        return new ScheduleDTO(t);
//      } catch (ParseException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//      }
//      return null;
//    }).collect(Collectors.toList());
//  }

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public Schedule create(@RequestBody ScheduleDTO scheduleDto) throws ParseException {
    Schedule schedule = new Schedule(scheduleDto);
    scheduleRepository.save(schedule);
    return schedule;
  }

  @GetMapping("/{id}")
  @Temporal(TemporalType.DATE)
  public List<ScheduleDTO> getScheduleByMovieAndCurrentDate(@PathVariable("id") long id)
      throws ParseException {
    Optional<Movie> movie = movieRepository.findById(id);
    List<ScheduleDTO> schedulesDTO = new ArrayList<ScheduleDTO>();
    List<Schedule> schedules = scheduleRepository.findAllByScheduledMovie(movie);
    for (Schedule s : schedules) {
      String stringDate=formatter.format(s.getDate());
      if (stringCurrentDate.equals(stringDate)) {
        ScheduleDTO scheduleDTO = new ScheduleDTO(s);
        schedulesDTO.add(scheduleDTO);
      }
    }
    return schedulesDTO.stream().sorted(comparatorSchedule::compare).collect(Collectors.toList());
  }
  
  @GetMapping("/{id}")
  @RequestMapping("changeScheduleByDate")
  @Temporal(TemporalType.DATE)
  public List<ScheduleDTO> getScheduleByMovieAndDate(@PathVariable("id") long id,@RequestBody Date date)
      throws ParseException {
    System.err.println("I'm here");
    Optional<Movie> movie = movieRepository.findById(id);
    List<ScheduleDTO> schedulesDTO = new ArrayList<ScheduleDTO>();
    List<Schedule> schedules = scheduleRepository.findAllByScheduledMovie(movie);
    for (Schedule s : schedules) {
      String stringDate=formatter.format(date);
      String databaseDateString=formatter.format(s.getDate());
      if (databaseDateString.equals(stringDate)) {
        ScheduleDTO scheduleDTO = new ScheduleDTO(s);
        schedulesDTO.add(scheduleDTO);
      }
    }
    return schedulesDTO.stream().sorted(comparatorSchedule::compare).collect(Collectors.toList());
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    this.scheduleRepository.deleteById(Long.parseLong(id));
  }

}
