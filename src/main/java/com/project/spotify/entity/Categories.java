package com.project.spotify.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categories")
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_categorie")
	private int id_categorie;

	@Column(name="nom_categorie")
	private String nom_categorie;

	@Column(name="img_categorie")
	private byte[] img_categorie;

	@OneToMany(mappedBy="categorie", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Titres> listTitres;

	public Categories() {

	}

	public Categories(String nom_categorie) {
		this.nom_categorie = nom_categorie;		
	}

	public Categories(String nom_categorie, List<Titres> listTitres) {
		this.nom_categorie = nom_categorie;	
		this.listTitres = listTitres;
	}
	
	public Categories(String nom_categorie, List<Titres> listTitres, byte[] img_categorie) {
		this.nom_categorie = nom_categorie;	
		this.listTitres = listTitres;
		this.img_categorie = img_categorie;
	}

	public Categories(int id_categorie, String nom_categorie) {
		this.id_categorie = id_categorie;
		this.nom_categorie = nom_categorie;		
	}

	public Categories(int id_categorie, String nom_categorie, List<Titres> listTitres) {
		this.id_categorie = id_categorie;
		this.nom_categorie = nom_categorie;		
		this.listTitres = listTitres;
	}
	
	public Categories(int id_categorie, String nom_categorie, List<Titres> listTitres,  byte[] img_categorie) {
		this.id_categorie = id_categorie;
		this.nom_categorie = nom_categorie;		
		this.listTitres = listTitres;
		this.img_categorie = img_categorie;
	}

	public int getId_categorie() {
		return id_categorie;
	}

	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}

	public String getNom_categorie() {
		return nom_categorie;
	}

	public void setNom_categorie(String nom_categorie) {
		this.nom_categorie = nom_categorie;
	}

	public List<Titres> getListTitres() {
		return listTitres;
	}

	public void setListTitres(List<Titres> listTitres) {
		this.listTitres = listTitres;
	}

	
	public byte[] getImg_categorie() {
		return img_categorie;
	}

	public void setImg_categorie(byte[] img_categorie) {
		this.img_categorie = img_categorie;
	}

	@Override
	public String toString() {
		return "Categories [id_categorie=" + id_categorie + ", nom_categorie=" + nom_categorie + ", img_categorie="
				+ Arrays.toString(img_categorie) + "]";
	}

}
