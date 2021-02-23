package com.sayan.moviecatalog.models;

public class Rating {

	String movieId;
	String rating;
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(String movieId, String rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Rating [movieId=" + movieId + ", rating=" + rating + "]";
	}
}
