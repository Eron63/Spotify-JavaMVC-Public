package com.project.spotify.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

	@Autowired
	private TitresService titresService;
	
	@Autowired
	private AlbumsService albumsService;
	
	@Autowired
	private CategoriesService categoriesService;
	
	@Autowired
	private ArtistesService artistesService;
	
	public List<Object> globalSearch(String search) {
		List<Object> list = new ArrayList<Object>();
		
		list.add(this.titresService.findByString(search));
		list.add(this.categoriesService.findByString(search));
		list.add(this.albumsService.findByString(search));
		list.add(this.artistesService.findByString(search));

		return list;
	}
}
