package com.sayan.moviecatalog.models;

import java.util.List;

public class RatingResponse {
	
	List<Rating> ratings;

	public RatingResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RatingResponse(List<Rating> ratings) {
		super();
		this.ratings = ratings;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "RatingResponse [ratings=" + ratings + "]";
	}
}
