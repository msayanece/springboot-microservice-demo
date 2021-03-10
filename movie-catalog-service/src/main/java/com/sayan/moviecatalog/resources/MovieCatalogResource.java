package com.sayan.moviecatalog.resources;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.sayan.moviecatalog.DBConfig;
import com.sayan.moviecatalog.models.CatalogItem;
import com.sayan.moviecatalog.models.Movie;
import com.sayan.moviecatalog.models.RatingResponse;
import com.sayan.moviecatalog.services.MovieInfoService;
import com.sayan.moviecatalog.services.RatingService;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	RatingService ratingService;
	
	@Autowired
	MovieInfoService movieInfoService;
	
    @Autowired
    WebClient.Builder webClientBuilder;
	
	@RequestMapping("/all/{userId}")
	public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId){
		//get movie list with ratings
		System.out.println("called");
		RatingResponse ratingResponse = ratingService.getRatingsResponse();
		
		
////		Alternative WebClient way
//		RatingResponse ratingResponse = webClientBuilder.build().get().uri("http://ratings-data-service/rating/foo/")
//		.retrieve().bodyToMono(RatingResponse.class).block();
		
		//get movie details and populate catalogs and then return 
		return ratingResponse.getRatings().stream().map(rating -> {
				Movie movie = movieInfoService.getMovieInfo(rating);
				return new CatalogItem(movie.getName(), "desc", rating.getRating());
			}).collect(Collectors.toList());
		
	}
	
	@Value("${testValue}")
	private String value;
	
	@Value("${valueNotFound: defaultValue}")
	private String defaultValue;

	@Value("${testList}")
	private List<String> values;
	
	@Value("#{${testMap}}")
	private Map<String, String> valueMap;
	
	@Value("${db.connection: defaultConnection}")
	private String dbConnectionValue;
	
	@RequestMapping("/test")
	public String test(){
		return "evaluated value: " + value + ", defaultValue: " + defaultValue + ", values: " + values + ", valueMap: " + valueMap;
	}
	
	@Autowired
	private DBConfig dBConfig;
	
	@RequestMapping("/dbCon")
	public String dbConnectionValue(){
		return dbConnectionValue + dBConfig.getUsername();
	}
}
