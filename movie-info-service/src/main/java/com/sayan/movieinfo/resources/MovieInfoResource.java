package com.sayan.movieinfo.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayan.movieinfo.models.Movie;

@RestController
@RequestMapping("/movie")
public class MovieInfoResource {

	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		if(movieId.equals("m123"))
			return new Movie("m123", "Tenet");
		else 
			return new Movie("m456", "Inception");
	}
}
