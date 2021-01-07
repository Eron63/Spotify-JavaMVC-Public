package com.project.spotify.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.spotify.entity.Titres;
import com.project.spotify.entity.Users;
import com.project.spotify.services.TitresService;

@RestController
@RequestMapping("/titres")
@CrossOrigin(origins="http://localhost:4200")
public class TitresController {
	
	@Autowired
	private TitresService titresService;
	
	@GetMapping("")
	public List<Titres> findAll()
	{
		return this.titresService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Titres> findById(@PathVariable(value="id") int id)
	{
		return this.titresService.findById(id);
	}
	
	@GetMapping("/by-album/{id}")
	public List<Titres> findByAlbum(@PathVariable(value="id") int id){
		return this.titresService.findByAlbum(id);
	}
	
	@GetMapping("/by-categorie/{id}")
	public List<Titres> findByCategorie(@PathVariable(value="id") int id){
		return this.titresService.findByCategorie(id);
	}
	
	@GetMapping("/by-categorie-20/{id}/{a}")
	public List<Titres> find20ByCategorie(@PathVariable(value="id") int id, @PathVariable(value="a") int a){
		return this.titresService.find20ByCategorie(id, a);
	}
	
	@GetMapping("/random")
	public List<Titres> random(){
		return this.titresService.random();
	}
	
	@GetMapping("/most-played")
	public List<Titres> findMostPlayed(){
		return this.titresService.findMostPlayed();
	}
	
	@PutMapping("/{id}")
	public Titres update(@PathVariable(value="id") int id, @RequestBody Titres newTitre) {
		Titres titre = this.titresService.findById(id).get();
		return this.titresService.update(newTitre, titre);
	}
}
