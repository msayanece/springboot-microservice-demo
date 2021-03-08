package com.sayan.moviecatalog.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sayan.moviecatalog.models.Rating;
import com.sayan.moviecatalog.models.RatingResponse;

@Service
public class RatingService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getRatingsResponseFallback")
	public RatingResponse getRatingsResponse() {
		RatingResponse ratingResponse = restTemplate.getForObject("http://ratings-data-service/rating/foo", RatingResponse.class);
		return ratingResponse;
	}
	
	public RatingResponse getRatingsResponseFallback() {
		return new RatingResponse(Arrays.asList(new Rating("-1", "0")));
	}
}
