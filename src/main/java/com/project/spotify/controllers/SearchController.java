package com.project.spotify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.spotify.services.SearchService;

@RestController
@RequestMapping("/search")
@CrossOrigin(origins="http://localhost:4200")
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@GetMapping("")
	public List<Object> globalSearch(@RequestParam("search") String search){
		return this.searchService.globalSearch(search);
	}
}
