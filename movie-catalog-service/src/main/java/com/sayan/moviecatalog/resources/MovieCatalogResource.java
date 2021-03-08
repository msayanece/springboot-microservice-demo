package com.sayan.moviecatalog.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.sayan.moviecatalog.models.CatalogItem;
import com.sayan.moviecatalog.models.Movie;
import com.sayan.moviecatalog.models.RatingResponse;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	RestTemplate restTemplate;
	
    @Autowired
    WebClient.Builder webClientBuilder;
	
	@RequestMapping("/all/{userId}")
	public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId){
		//get movie list with ratings
		System.out.println("called");
		RatingResponse ratingResponse = restTemplate.getForObject("http://ratings-data-service/rating/foo", RatingResponse.class);
		
		
////		Alternative WebClient way
//		RatingResponse ratingResponse = webClientBuilder.build().get().uri("http://ratings-data-service/rating/foo/")
//		.retrieve().bodyToMono(RatingResponse.class).block();
		
		//get movie details and populate catalogs and then return 
		return ratingResponse.getRatings().stream().map(rating -> {
				Movie movie = restTemplate.getForObject("http://movie-info-service/movie/"+rating.getMovieId(), Movie.class);
				return new CatalogItem(movie.getName(), "desc", rating.getRating());
			}).collect(Collectors.toList());
		
	}
	

	@RequestMapping("/test")
	public String getCatalogs(){
		return "connection OK";
	}
}
