package com.project.spotify.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="playlists")
public class Playlists {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_playlist")
	private int id_playlist;
	
	@Column(name="nom_playlist")
	private String nom_playlist;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name="id_user")
	private Users user;
	
	@ManyToMany
	@JoinTable(
			name="playlists_titres",
			joinColumns = { @JoinColumn(name="id_playlist") },
			inverseJoinColumns = { @JoinColumn(name="id_titre") })
	private List<Titres> listTitres;
	
	public Playlists() {		
	}
	
	public Playlists(String nom_playlist, Users user) {
		this.nom_playlist = nom_playlist;
		this.user = user;
	}
	
	public Playlists(String nom_playlist, Users user, List<Titres> titres) {
		this.nom_playlist = nom_playlist;
		this.user = user;
		this.listTitres =titres;
	}
	
	public Playlists(int id_playlist, String nom_playlist, Users user) {
		this.id_playlist = id_playlist;
		this.nom_playlist = nom_playlist;
		this.user = user;
	}
	
	public Playlists(int id_playlist, String nom_playlist, Users user, List<Titres> titres) {
		this.id_playlist = id_playlist;
		this.nom_playlist = nom_playlist;
		this.user = user;
		this.listTitres =titres;
	}

	public int getId_playlist() {
		return id_playlist;
	}

	public void setId_playlist(int id_playlist) {
		this.id_playlist = id_playlist;
	}

	public String getNom_playlist() {
		return nom_playlist;
	}

	public void setNom_playlist(String nom_playlist) {
		this.nom_playlist = nom_playlist;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Titres> getListTitres() {
		return listTitres;
	}

	public void setListTitres(List<Titres> listTitres) {
		this.listTitres = listTitres;
	}
	
	public void addTitre(Titres titre){
		if(this.listTitres == null) {
			this.listTitres = new ArrayList<Titres>();
		}
		this.listTitres.add(titre);
	}
	
	public void removeTitre(Titres titre){
		if(this.listTitres == null) {
			this.listTitres = new ArrayList<Titres>();
		}
		
		this.listTitres.remove(titre);
	}
	
	@Override
	public String toString() {
		return "Playlists [id_playlist=" + id_playlist + ", nom_playlist=" + nom_playlist + ", user=" + user
				+ ", listTitres=" + listTitres + "]";
	}
}
