package com.sayan.ratingsdata.resouces;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayan.ratingsdata.models.Rating;
import com.sayan.ratingsdata.models.RatingResponse;

@RestController
public class RatingsResource {

	@RequestMapping("/rating/{userId}")
	public RatingResponse getMovieInfo(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(new Rating("m123", "4"), new Rating("m456", "3.5"));
		return new RatingResponse(ratings);
	}
}
