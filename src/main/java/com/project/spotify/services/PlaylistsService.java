package com.project.spotify.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spotify.dao.PlaylistsRepository;
import com.project.spotify.entity.Playlists;
import com.project.spotify.entity.Titres;
import com.project.spotify.entity.Users;

@Service
public class PlaylistsService {

	@Autowired
	PlaylistsRepository playlistsRepository;
	
	@Autowired
	EntityManager entityManager;
	
	public List<Playlists> findAll()
	{
		return this.playlistsRepository.findAll();
	}
	
	public Optional<Playlists> findById(int id)
	{
		return this.playlistsRepository.findById(id);
	}
	
	public List<Playlists> findByUser(int id)
	{
		return this.entityManager.createQuery("FROM Playlists WHERE id_user = '" + id + "'").getResultList();
	}
	
	public Playlists create(Playlists playlist, Users user) 
	{
		playlist.setUser(user);
		return this.playlistsRepository.save(playlist);
	}
	
	public Playlists update(Playlists newPlaylist, Playlists playlist)
	{
		newPlaylist.setId_playlist(playlist.getId_playlist());
		return this.playlistsRepository.save(newPlaylist);
	}
	
	public void delete(int id)
	{
		this.playlistsRepository.deleteById(id);
	}
	
	public Playlists addTitreToPlaylist(Playlists playlist, Titres titre) {
		playlist.addTitre(titre);
		return this.playlistsRepository.save(playlist);
	}
	
	public Playlists removeTitreFromPlaylist(Playlists playlist, Titres titre) {
		System.out.println(playlist.getListTitres());
		System.out.println(titre.getId_titre());
		playlist.removeTitre(titre);
		return this.playlistsRepository.save(playlist);
	}
}
