package com.project.spotify.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spotify.dao.AlbumsRepository;
import com.project.spotify.entity.Albums;
import com.project.spotify.entity.Titres;

@Service
public class AlbumsService {

	@Autowired
	private AlbumsRepository albumsRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Albums> findAll()
	{
		return this.albumsRepository.findAll();
	}
	
	public Optional<Albums> findById(int id)
	{
		return this.albumsRepository.findById(id);
	}
	
	public Albums create(Albums albums) 
	{
		return this.albumsRepository.save(albums);
	}
	
	public Albums update(Albums newAlbums, Albums albums)
	{
		newAlbums.setId_album(albums.getId_album());
		return this.albumsRepository.save(newAlbums);
	}
	
	public void delete(int id)
	{
		this.albumsRepository.deleteById(id);
	}
	
	public List<Albums> findByString(String search){
		if(search.length() == 0) {
			return null;
		}
		return this.entityManager.createQuery("FROM Albums WHERE nom_album LIKE '%" + search + "%'").getResultList();
	}
	
	public List<Albums> findByArtistes(int id){
		return this.entityManager.createQuery("FROM Albums WHERE id_artiste = '" + id + "'").getResultList();
	}
	
	public List<Albums> findByDate(){
		return this.entityManager.createQuery("FROM Albums ORDER BY date_album DESC").getResultList();
	}
}
