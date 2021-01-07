package com.project.spotify.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spotify.dao.ArtistesRepository;
import com.project.spotify.entity.Artistes;
import com.project.spotify.entity.Titres;

@Service
public class ArtistesService {

	@Autowired
	private ArtistesRepository artistesRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Artistes> findAll()
	{
		return this.artistesRepository.findAll();
	}
	
	public Optional<Artistes> findById(int id)
	{
		return this.artistesRepository.findById(id);
	}
	
	public Artistes create(Artistes artistes) 
	{
		return this.artistesRepository.save(artistes);
	}
	
	public Artistes update(Artistes newArtistes, Artistes artistes)
	{
		newArtistes.setId_artiste(artistes.getId_artiste());
		return this.artistesRepository.save(newArtistes);
	}
	
	public void delete(int id)
	{
		this.artistesRepository.deleteById(id);
	}
	
	public List<Artistes> findByString(String search){
		if(search.length() == 0) {
			return null;
		}
		return this.entityManager.createQuery("FROM Artistes WHERE nom_artiste LIKE '%" + search + "%'").getResultList();
	}
}
