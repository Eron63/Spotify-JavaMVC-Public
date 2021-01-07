package com.project.spotify.entity;

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
@Table(name="morceaux")
public class Morceaux {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_morceau")
	private int id_morceau;
	
	@Column(name="blob_morceau")
	private byte[]  blob_morceau;
	
	@OneToMany(mappedBy="morceau", cascade=CascadeType.ALL, orphanRemoval=true)
	@JsonIgnore
    private List<Titres> listTitres;
	
	public Morceaux() {
		
	}
	
	public Morceaux( byte[] blob_morceau) {
		this.blob_morceau = blob_morceau;
	}
	
	public Morceaux( byte[] blob_morceau, List<Titres> listTitres) {
		this.blob_morceau = blob_morceau;	
		this.listTitres = listTitres;
	}
	
	public Morceaux(int id_morceau, byte[] blob_morceau) {
		this.id_morceau = id_morceau;	
		this.blob_morceau = blob_morceau;
	}
	
	public Morceaux(int id_morceau, byte[] blob_morceau, List<Titres> listTitres) {
		this.id_morceau = id_morceau;	
		this.blob_morceau = blob_morceau;	
		this.listTitres = listTitres;
	}

	public int getId_morceau() {
		return id_morceau;
	}

	public void setId_morceau(int id_morceau) {
		this.id_morceau = id_morceau;
	}

	public byte[] getBlob_morceau() {
		return blob_morceau;
	}

	public void setBlob_morceau(byte[] blob_morceau) {
		this.blob_morceau = blob_morceau;
	}

	public List<Titres> getListTitres() {
		return listTitres;
	}

	public void setListTitres(List<Titres> listTitres) {
		this.listTitres = listTitres;
	}	

	
}
