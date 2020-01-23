package com.ctbav.internship.cineplexbackend.controllers;

import java.text.ParseException;
import java.util.ArrayList;
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
import com.ctbav.internship.cineplexbackend.DTO.MovieDTO;
import com.ctbav.internship.cineplexbackend.models.Movie;
import com.ctbav.internship.cineplexbackend.repositories.MovieRepository;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private MovieController(MovieRepository repo) {
		this.movieRepository = repo;
	}

	@GetMapping()
	public List<MovieDTO> list() throws ParseException {
		List<Movie> movies = new ArrayList<Movie>();
		movies = movieRepository.findAll();
		List<MovieDTO> list = new ArrayList<MovieDTO>();
		MovieDTO movieDTO;
		for (Movie m : movies) {
			movieDTO = new MovieDTO(m);
			list.add(movieDTO);

		}

		return list;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public MovieDTO create(@RequestBody MovieDTO movieDto) throws ParseException {
		Movie movie = new Movie(movieDto);
		movieRepository.save(movie);
		MovieDTO movieDTO = new MovieDTO(movie);
		return movieDTO;
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public MovieDTO get(@PathVariable("id") long id) throws ParseException {
		Movie movie = movieRepository.getOne(id);
		MovieDTO movieDto = new MovieDTO(movie);
		System.out.println(movieDto.toString());
		return movieDto;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.movieRepository.deleteById(Long.parseLong(id));
	}
}
