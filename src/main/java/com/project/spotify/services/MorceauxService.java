package com.project.spotify.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spotify.dao.MorceauxRepository;
import com.project.spotify.entity.Morceaux;

@Service
public class MorceauxService {

	@Autowired
	MorceauxRepository morceauxRepository;
	
	@Autowired
	EntityManager entityManager;
	
	public List<Morceaux> findAll()
	{
		return this.morceauxRepository.findAll();
	}
	
	public Optional<Morceaux> findById(int id)
	{
		return this.morceauxRepository.findById(id);
	}
	
	public List<Object> findByAlbum(int id)
	{
		@SuppressWarnings("unchecked")
		List<Object> list = this.entityManager.createQuery("FROM Morceaux as m INNER JOIN Titres as t WHERE t.album = '" + id + "'").getResultList();
		System.out.println(list);
		return list;
	}
	
	public Morceaux create(Morceaux morceaux) 
	{
		return this.morceauxRepository.save(morceaux);
	}
	
	public Morceaux update(Morceaux newMorceaux, Morceaux morceaux)
	{
		newMorceaux.setId_morceau(morceaux.getId_morceau());
		return this.morceauxRepository.save(newMorceaux);
	}
	
	public void delete(int id)
	{
		this.morceauxRepository.deleteById(id);
	}
}
