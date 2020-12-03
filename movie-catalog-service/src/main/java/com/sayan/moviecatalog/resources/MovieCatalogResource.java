package com.sayan.moviecatalog.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayan.moviecatalog.models.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId){
		return Collections.singletonList(
			new CatalogItem("Forest Gump", 
					"Forrest Gump is a 1994 American romantic "
					+ "comedy-drama film directed by Robert Zemeckis "
					+ "and written by Eric Roth. It is based on the 1986 novel "
					+ "of the same name by Winston Groom and stars Tom Hanks, "
					+ "Robin Wright, Gary Sinise, Mykelti Williamson and Sally Field.",
					4
					)
				);
	}
}
