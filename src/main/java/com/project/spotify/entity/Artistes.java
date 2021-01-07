package com.project.spotify.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="artistes")
public class Artistes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_artiste")
	private int id_artiste;
	
	@Column(name="nom_artiste")
	private String nom_artiste;
	
	@Column(name="img_artiste")
	private byte[] img_artiste;

	@Column(name="biographie")
	private String biographie;
	
	@OneToMany(mappedBy="artiste", cascade=CascadeType.ALL, orphanRemoval=true)
	@JsonIgnore
	private List<Albums> listAlbums;	
	
	@ManyToMany
	@JoinTable(
			name="artistes_titres",
			joinColumns = { @JoinColumn(name="id_artiste") },
			inverseJoinColumns = { @JoinColumn(name="id_titre") })
	@JsonIgnore
	private List<Titres> listTitres;
	
	public Artistes() {
		
	}
	
	public Artistes(String nom_artiste) {
		this.nom_artiste = nom_artiste;		
	}
	
	public Artistes(String nom_artiste, List<Albums> listAlbums) {
		this.nom_artiste = nom_artiste;	
		this.listAlbums = listAlbums;
	}
	
	public Artistes(String nom_artiste, List<Albums> listAlbums, List<Titres> listTitres) {
		this.nom_artiste = nom_artiste;	
		this.listAlbums = listAlbums;
		this.listTitres = listTitres;
	}
	
	public Artistes(String nom_artiste, byte[] img_artiste, String biographie, List<Albums> listAlbums,
			List<Titres> listTitres) {
		this.nom_artiste = nom_artiste;
		this.img_artiste = img_artiste;
		this.biographie = biographie;
		this.listAlbums = listAlbums;
		this.listTitres = listTitres;
	}
	
	public Artistes(int id_artiste, String nom_artiste) {
		this.id_artiste = id_artiste;
		this.nom_artiste = nom_artiste;	
	}
		
	public Artistes(int id_artiste, String nom_artiste, List<Albums> listAlbums) {
		this.id_artiste = id_artiste;
		this.nom_artiste = nom_artiste;	
		this.listAlbums = listAlbums;
	}
	
	public Artistes(int id_artiste, String nom_artiste, List<Albums> listAlbums, List<Titres> listTitres) {
		this.id_artiste = id_artiste;
		this.nom_artiste = nom_artiste;	
		this.listAlbums = listAlbums;
		this.listTitres = listTitres;
	}
	
	public Artistes(int id_artiste, String nom_artiste, byte[] img_artiste, String biographie, List<Albums> listAlbums,
			List<Titres> listTitres) {
		this.id_artiste = id_artiste;
		this.nom_artiste = nom_artiste;
		this.img_artiste = img_artiste;
		this.biographie = biographie;
		this.listAlbums = listAlbums;
		this.listTitres = listTitres;
	}

	public int getId_artiste() {
		return id_artiste;
	}

	public void setId_artiste(int id_artiste) {
		this.id_artiste = id_artiste;
	}

	public String getNom_artiste() {
		return nom_artiste;
	}

	public void setNom_artiste(String nom_artiste) {
		this.nom_artiste = nom_artiste;
	}
	
	public byte[] getImg_artiste() {
		return img_artiste;
	}

	public void setImg_artiste(byte[] img_artiste) {
		this.img_artiste = img_artiste;
	}

	public String getBiographie() {
		return biographie;
	}

	public void setBiographie(String biographie) {
		this.biographie = biographie;
	}

	public List<Albums> getListAlbums() {
		return listAlbums;
	}

	public void setListAlbums(List<Albums> listAlbums) {
		this.listAlbums = listAlbums;
	}

	public List<Titres> getListTitres() {
		return listTitres;
	}

	public void setListTitres(List<Titres> listTitres) {
		this.listTitres = listTitres;
	}	
		
}
