package com.ctbav.internship.cineplexbackend.controllers;

import java.text.ParseException;
import java.util.Date;
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
import com.ctbav.internship.cineplexbackend.DTO.MovieDTO;
import com.ctbav.internship.cineplexbackend.models.Movie;
import com.ctbav.internship.cineplexbackend.repositories.MovieRepository;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

  private static final Date CurrentDate = new Date();

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private MovieController(MovieRepository repo) {
    this.movieRepository = repo;
  }

  @GetMapping()
  public List<MovieDTO> list() throws ParseException {
    List<Movie> soonMovies = movieRepository.findAll().stream().filter(m -> {
      try {
        return CurrentDate.after(m.getCinemaDate());
      } catch (ParseException e) {
        e.printStackTrace();
      }
      return false;
    }).collect(Collectors.toList());
    return soonMovies.stream().map(m -> {
      try {
        return new MovieDTO(m);
      } catch (ParseException e) {
        e.printStackTrace();
      }
      return null;
    }).collect(Collectors.toList());
  }

  @GetMapping()
  @RequestMapping("/soon")
  public List<MovieDTO> listSoonMovies() {
    List<Movie> soonMovies = movieRepository.findAll().stream().filter(m -> {
      try {
        return CurrentDate.before(m.getCinemaDate());
      } catch (ParseException e) {
        e.printStackTrace();
      }
      return false;
    }).collect(Collectors.toList());
    return soonMovies.stream().map(m -> {
      try {
        return new MovieDTO(m);
      } catch (ParseException e) {
        e.printStackTrace();
      }
      return null;
    }).collect(Collectors.toList());
  }



  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public Movie create(@RequestBody MovieDTO movieDto) throws ParseException {
    Movie movie = new Movie(movieDto);
    movieRepository.save(movie);
    return movie;
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  public MovieDTO get(@PathVariable("id") long id) throws ParseException {
    Movie movie = movieRepository.getOne(id);
    MovieDTO movieDto = new MovieDTO(movie);
    return movieDto;
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    this.movieRepository.deleteById(Long.parseLong(id));
  }
}
