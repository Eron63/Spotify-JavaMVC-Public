package com.project.spotify.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="titres")
public class Titres{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_titre")
	private int id_titre;
		
	@Column(name="nom_titre")
	private String nom_titre;	

	@Column(name="nb_vues")
	private int nb_vues;
	
	@ManyToOne( cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name="id_morceau")
	@JsonIgnore
	private Morceaux morceau;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name="id_album")
	@JsonIgnore
	private Albums album;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name="id_categorie")
	@JsonIgnore
	private Categories categorie;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="listTitres")
	@JsonIgnore
	private List<Playlists> listPlaylists;	
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="listTitres")
	private List<Artistes> listArtistes;	
	
	public Titres() {
		
	}
	
	public Titres(String nom_titre) {
		this.nom_titre = nom_titre;		
	}
	
	public Titres(String nom_titre, int nb_vues) {
		this.nom_titre = nom_titre;	
		this.nb_vues = nb_vues;	
	}
	
	public Titres(String nom_titre, int nb_vues, Morceaux morceau) {
		this.nom_titre = nom_titre;	
		this.nb_vues = nb_vues;	
		this.morceau = morceau;			
	}
	
	public Titres(String nom_titre, int nb_vues, Morceaux morceau, Albums album) {
		this.nom_titre = nom_titre;	
		this.nb_vues = nb_vues;	
		this.morceau = morceau;	
		this.album = album;	
	}
	
	public Titres(String nom_titre, int nb_vues, Morceaux morceau, Albums album, Categories categorie) {
		this.nom_titre = nom_titre;	
		this.nb_vues = nb_vues;	
		this.morceau = morceau;	
		this.album = album;	
		this.categorie = categorie;	
	}
	
	public Titres(String nom_titre, int nb_vues, Morceaux morceau, Albums album, Categories categorie, List<Playlists> playlists) {
		this.nom_titre = nom_titre;	
		this.nb_vues = nb_vues;	
		this.morceau = morceau;	
		this.album = album;	
		this.categorie = categorie;	
		this.listPlaylists = playlists;
	}
	
	public Titres(String nom_titre, int nb_vues, Morceaux morceau, Albums album, Categories categorie, List<Playlists> playlists, List<Artistes> artistes) {
		this.nom_titre = nom_titre;	
		this.nb_vues = nb_vues;	
		this.morceau = morceau;	
		this.album = album;	
		this.categorie = categorie;	
		this.listPlaylists = playlists;
		this.listArtistes = artistes;
	}
	
	public Titres(int id_titre, String nom_titre) {
		this.id_titre = id_titre;
		this.nom_titre = nom_titre;		
	}
	
	public Titres(int id_titre, String nom_titre, int nb_vues) {
		this.id_titre = id_titre;
		this.nom_titre = nom_titre;	
		this.nb_vues = nb_vues;	
	}
	
	public Titres(int id_titre, String nom_titre, int nb_vues, Morceaux morceau) {
		this.id_titre = id_titre;
		this.nom_titre = nom_titre;	
		this.nb_vues = nb_vues;	
		this.morceau = morceau;			
	}
	
	public Titres(int id_titre, String nom_titre, int nb_vues, Morceaux morceau, Albums album) {
		this.id_titre = id_titre;
		this.nom_titre = nom_titre;	
		this.nb_vues = nb_vues;	
		this.morceau = morceau;	
		this.album = album;	
	}
	
	public Titres(int id_titre, String nom_titre, int nb_vues, Morceaux morceau, Albums album, Categories categorie) {
		this.id_titre = id_titre;
		this.nom_titre = nom_titre;	
		this.nb_vues = nb_vues;	
		this.morceau = morceau;	
		this.album = album;	
		this.categorie = categorie;	
	}
	
	public Titres(int id_titre, String nom_titre, int nb_vues, Morceaux morceau, Albums album, Categories categorie, List<Playlists> playlists) {
		this.id_titre = id_titre;
		this.nom_titre = nom_titre;	
		this.nb_vues = nb_vues;	
		this.morceau = morceau;	
		this.album = album;	
		this.categorie = categorie;	
		this.listPlaylists = playlists;
	}
	
	public Titres(int id_titre, String nom_titre, int nb_vues, Morceaux morceau, Albums album, Categories categorie, List<Playlists> playlists, List<Artistes> artistes) {
		this.id_titre = id_titre;
		this.nom_titre = nom_titre;	
		this.nb_vues = nb_vues;	
		this.morceau = morceau;	
		this.album = album;	
		this.categorie = categorie;	
		this.listPlaylists = playlists;
		this.listArtistes = artistes;
	}

	public int getId_titre() {
		return id_titre;
	}

	public void setId_titre(int id_titre) {
		this.id_titre = id_titre;
	}

	public String getNom_titre() {
		return nom_titre;
	}

	public void setNom_titre(String nom_titre) {
		this.nom_titre = nom_titre;
	}

	public int getNb_vues() {
		return nb_vues;
	}

	public void setNb_vues(int nb_vues) {
		this.nb_vues = nb_vues;
	}

	public Morceaux getMorceau() {
		return morceau;
	}

	public void setMorceau(Morceaux morceau) {
		this.morceau = morceau;
	}

	public Albums getAlbum() {
		return album;
	}

	public void setAlbum(Albums album) {
		this.album = album;
	}

	public Categories getCategorie() {
		return categorie;
	}

	public void setCategorie(Categories categorie) {
		this.categorie = categorie;
	}

	public List<Playlists> getListPlaylists() {
		return listPlaylists;
	}

	public void setListPlaylists(List<Playlists> listPlaylists) {
		this.listPlaylists = listPlaylists;
	}

	public List<Artistes> getListArtistes() {
		return listArtistes;
	}

	public void setListArtistes(List<Artistes> listArtistes) {
		this.listArtistes = listArtistes;
	}

	@Override
	public String toString() {
		return "Titres [id_titre=" + id_titre + ", nom_titre=" + nom_titre + ", nb_vues=" + nb_vues + "]";
	}
	
	
}
