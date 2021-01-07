package com.project.spotify.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.spotify.entity.Playlists;
import com.project.spotify.entity.Titres;
import com.project.spotify.entity.Users;
import com.project.spotify.services.PlaylistsService;
import com.project.spotify.services.UserService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/playlists")
@CrossOrigin(origins="http://localhost:4200")
public class PlaylistsController {

	@Autowired
	private PlaylistsService playlistsService;

	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public List<Playlists> findAll()
	{
		return this.playlistsService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Playlists> findById(@PathVariable(value = "id") int id) 
	{
		return this.playlistsService.findById(id);
	}
	
	@GetMapping("/by-user/{id}")
	public List<Playlists> findByUser(@PathVariable(value = "id") int id) 
	{
		return this.playlistsService.findByUser(id);
	}

	@PostMapping("")
	public Playlists createPlaylists(@RequestBody Playlists playlist) throws NotFoundException
	{
		System.out.println(playlist.getUser());
		Optional<Users> user = this.userService.findById(playlist.getUser().getId_user());
		
		if(!user.isPresent()) {
			throw new NotFoundException("NOT FOUND");
		}
		return this.playlistsService.create(playlist, user.get());
	}

	@PutMapping("/{id}")
	public Playlists updatePlaylists(@PathVariable(value="id") int id, @RequestBody Playlists newPlaylists)
	{
		Playlists playlists = this.playlistsService.findById(id).get();
		return this.playlistsService.update(newPlaylists, playlists);
	}
	
	@PutMapping("/add/{id}")
	public Playlists addTitreToPlaylist(@PathVariable(value="id") int id, @RequestBody Titres titre) throws NotFoundException {
		Playlists playlist = this.playlistsService.findById(id).get();
		
		if(playlist == null) {
			throw new NotFoundException("PLAYLIST NOT FOUND");
		}
		
		return this.playlistsService.addTitreToPlaylist(playlist, titre);
	}
	
	@PutMapping("/remove/{id}")
	public Playlists removeTitreFromPlaylist(@PathVariable(value="id") int id, @RequestBody Titres titre) throws NotFoundException {
		Playlists playlist = this.playlistsService.findById(id).get();
		
		if(playlist == null) {
			throw new NotFoundException("PLAYLIST NOT FOUND");
		}
		
		return this.playlistsService.removeTitreFromPlaylist(playlist, titre);
	}

	@DeleteMapping("/{id}")
	public void deletePlaylists(@PathVariable(value="id") int id)
	{
		this.playlistsService.delete(id);
	}
}
