package com.project.spotify.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spotify.dao.TitresRepository;
import com.project.spotify.entity.Titres;

@Service
public class TitresService {

	@Autowired
	private TitresRepository titresRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Titres> findAll()
	{
		return this.titresRepository.findAll();
	}

	public Optional<Titres> findById(int id)
	{
		return this.titresRepository.findById(id);
	}

	public Titres create(Titres titre) 
	{
		return this.titresRepository.save(titre);
	}

	public Titres update(Titres newTitre, Titres titre)
	{
		newTitre.setId_titre(titre.getId_titre());
		newTitre.setMorceau(titre.getMorceau());
		newTitre.setAlbum(titre.getAlbum());
		newTitre.setCategorie(titre.getCategorie());
		return this.titresRepository.save(newTitre);
	}

	public void delete(int id)
	{
		this.titresRepository.deleteById(id);
	}

	public List<Titres> findByAlbum(int idAlbum){
		return this.entityManager.createQuery("FROM Titres WHERE id_album ='" + idAlbum + "'").getResultList();
	}

	public List<Titres> findByCategorie(int idCategorie){
		return this.entityManager.createQuery("FROM Titres WHERE id_categorie ='" + idCategorie + "'").getResultList();
	}

	public List<Titres> find20ByCategorie(int idCategorie, int a){
		Query q = this.entityManager.createQuery("FROM Titres WHERE id_categorie ='" + idCategorie + "'")
				.setFirstResult(a).setMaxResults(20);
		
		return q.getResultList();
	}
	
	public List<Titres> random(){

		Query q = this.entityManager.createQuery("FROM Titres WHERE RAND() > 0.9 ORDER BY RAND()")
				.setFirstResult(10).setMaxResults(10);

		return q.getResultList();
	}

	public List<Titres> findMostPlayed(){
		return this.entityManager.createQuery("FROM Titres t ORDER BY t.nb_vues DESC")
				.setFirstResult(0).setMaxResults(10).getResultList();
	}

	public List<Titres> findByString(String search){
		if(search.length() == 0) {
			return null;
		}
		return this.entityManager.createQuery("FROM Titres WHERE nom_titre LIKE '%" + search + "%'").getResultList();
	}
}
