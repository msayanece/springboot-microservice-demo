package com.sayan.movieinfo.models;

public class Movie {
	
	String id;
	String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + "]";
	}
	
}
