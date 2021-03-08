package com.sayan.moviecatalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sayan.moviecatalog.models.Movie;
import com.sayan.moviecatalog.models.Rating;

@Service
public class MovieInfoService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getMovieInfoFallback")
	public Movie getMovieInfo(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movie/"+rating.getMovieId(), Movie.class);
		return movie;
	}
	
	public Movie getMovieInfoFallback(Rating rating) {
		return new Movie("-1", "No name found!");
	}
}
