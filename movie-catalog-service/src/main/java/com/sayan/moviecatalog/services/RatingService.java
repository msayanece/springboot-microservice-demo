package com.sayan.moviecatalog.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sayan.moviecatalog.models.Rating;
import com.sayan.moviecatalog.models.RatingResponse;

@Service
public class RatingService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getRatingsResponseFallback",
				commandProperties = {
						@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
						@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
						@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
						@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
				},
				threadPoolKey = "ratingPool",
				threadPoolProperties = {
						@HystrixProperty(name = "coreSize", value = "20"),
						@HystrixProperty(name = "maxQueueSize", value = "10")
				}
			)
	public RatingResponse getRatingsResponse() {
		RatingResponse ratingResponse = restTemplate.getForObject("http://ratings-data-service/rating/foo", RatingResponse.class);
		return ratingResponse;
	}
	
	public RatingResponse getRatingsResponseFallback() {
		return new RatingResponse(Arrays.asList(new Rating("-1", "0")));
	}
}
