package com.project.spotify.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.spotify.entity.Morceaux;
import com.project.spotify.services.MorceauxService;

@RestController
@RequestMapping("/morceaux")
public class MorceauxController {

	@Autowired
	private MorceauxService morceauxService;

	@GetMapping("")
	public List<Morceaux> findAll()
	{
		return this.morceauxService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Morceaux> findById(@PathVariable(value="id") int id)
	{
		return this.morceauxService.findById(id);
	}
	
	@GetMapping("/by-album/{id}")
	public List<Object> findByAlbum(@PathVariable(value="id") int id){
		return this.morceauxService.findByAlbum(id);
	}
	
}
