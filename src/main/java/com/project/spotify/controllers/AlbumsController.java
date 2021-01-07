package com.project.spotify.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.spotify.entity.Albums;
import com.project.spotify.services.AlbumsService;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

	@Autowired
	private AlbumsService albumsService;

	@GetMapping("")
	public List<Albums> findAll()
	{
		return this.albumsService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Albums> findById(@PathVariable("id") int id)
	{
		return this.albumsService.findById(id);
	}
	
	@GetMapping("/by-artiste/{id}")
	public List<Albums> findByArtistes(@PathVariable("id") int id){
		return this.albumsService.findByArtistes(id);
	}
}
