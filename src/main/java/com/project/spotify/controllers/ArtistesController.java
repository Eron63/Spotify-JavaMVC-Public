package com.project.spotify.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.spotify.entity.Artistes;
import com.project.spotify.services.ArtistesService;

@RestController
@RequestMapping("/artistes")
public class ArtistesController {

	@Autowired
	private ArtistesService artistesService;

	@GetMapping("")
	public List<Artistes> findAll()
	{
		return this.artistesService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Artistes> findById(@PathVariable(value="id") int id)
	{
		return this.artistesService.findById(id);
	}
}
