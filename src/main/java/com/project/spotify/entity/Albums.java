package com.project.spotify.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="albums")
public class Albums implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7790091800646882665L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_album")
	private int id_album;
	
	@Column(name="nom_album")
	private String nom_album;
	
	@Column(name="date_album")
	private int date_album;
	
	@Column(name="img_album")
	private byte[]  img_album;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name="id_artiste")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Artistes artiste;	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="album", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Titres> listTitres;
	
	public Albums() {
		
	}
	
	public Albums(String nom_album) {
		this.nom_album = nom_album;		
	}
	
	public Albums(String nom_album, int date_album) {
		this.nom_album = nom_album;
		this.date_album = date_album;
	}
	
	public Albums(String nom_album, int date_album, byte[] img_album) {
		this.nom_album = nom_album;
		this.date_album = date_album;
		this.img_album = img_album;
	}
	
	public Albums(String nom_album, int date_album, byte[] img_album, Artistes artiste) {
		this.nom_album = nom_album;
		this.date_album = date_album;
		this.img_album = img_album;
		this.artiste = artiste;
	}
	
	public Albums(String nom_album, int date_album, byte[] img_album, Artistes artiste, List<Titres> listTitres) {
		this.nom_album = nom_album;
		this.date_album = date_album;
		this.img_album = img_album;
		this.artiste = artiste;
		this.listTitres = listTitres;
	}
	
	
	public Albums(int id_album, String nom_album) {
		this.id_album = id_album;
		this.nom_album = nom_album;		
	}
	
	public Albums(int id_album, String nom_album, int date_album) {
		this.id_album = id_album;
		this.nom_album = nom_album;
		this.date_album = date_album;
	}
	
	public Albums(int id_album, String nom_album, int date_album, byte[] img_album) {
		this.id_album = id_album;
		this.nom_album = nom_album;
		this.date_album = date_album;
		this.img_album = img_album;
	}
	
	public Albums(int id_album, String nom_album, int date_album, byte[] img_album, Artistes artiste) {
		this.id_album = id_album;
		this.nom_album = nom_album;
		this.date_album = date_album;
		this.img_album = img_album;
		this.artiste = artiste;
	}
	
	public Albums(int id_album, String nom_album, int date_album, byte[] img_album, Artistes artiste, List<Titres> listTitres) {
		this.id_album = id_album;
		this.nom_album = nom_album;
		this.date_album = date_album;
		this.img_album = img_album;
		this.artiste = artiste;
		this.listTitres = listTitres;
	}

	public int getId_album() {
		return id_album;
	}

	public void setId_album(int id_album) {
		this.id_album = id_album;
	}

	public String getNom_album() {
		return nom_album;
	}

	public void setNom_album(String nom_album) {
		this.nom_album = nom_album;
	}

	public int getDate_album() {
		return date_album;
	}

	public void setDate_album(int date_album) {
		this.date_album = date_album;
	}

	public byte[] getImg_album() {
		return img_album;
	}

	public void setImg_album(byte[] img_album) {
		this.img_album = img_album;
	}

	public Artistes getArtiste() {
		return artiste;
	}

	public void setArtiste(Artistes artiste) {
		this.artiste = artiste;
	}

	public List<Titres> getListTitres() {
		return listTitres;
	}

	public void setListTitres(List<Titres> listTitres) {
		this.listTitres = listTitres;
	}

}
