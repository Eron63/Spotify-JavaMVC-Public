package com.project.spotify.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_user")
	private int id_user;

	@Column(name="email_user")
	private String email_user;

	@Column(name="nom_user")
	private String nom_user;

	@Column(name="img_user")
	private byte[] img_user;

	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Playlists> listPlaylist;	

	public Users() {}

	public Users(String email_user, String nom_user) {
		this.email_user = email_user;
		this.nom_user = nom_user;
	}

	public Users(String email_user, String nom_user, byte[] img_user) {
		this.email_user = email_user;
		this.nom_user = nom_user;
		this.img_user = img_user;
	}

	public Users(String email_user, String nom_user, List<Playlists> listPlaylist) {
		this.email_user = email_user;
		this.nom_user = nom_user;
		this.listPlaylist = listPlaylist;
	}

	public Users(String email_user, String nom_user, byte[] img_user, List<Playlists> listPlaylist) {
		this.email_user = email_user;
		this.nom_user = nom_user;
		this.img_user = img_user;
		this.listPlaylist = listPlaylist;
	}

	public Users(int id_user, String email_user, String nom_user) {
		this.id_user = id_user;
		this.email_user = email_user;
		this.nom_user = nom_user;
	}

	public Users(int id_user, String email_user, String nom_user, byte[] img_user) {
		this.id_user = id_user;
		this.email_user = email_user;
		this.nom_user = nom_user;
		this.img_user = img_user;
	}

	public Users(int id_user, String email_user, String nom_user, List<Playlists> listPlaylist) {
		this.id_user = id_user;
		this.email_user = email_user;
		this.nom_user = nom_user;
		this.listPlaylist = listPlaylist;
	}

	public Users(int id_user, String email_user, String nom_user, byte[] img_user, List<Playlists> listPlaylist) {
		this.id_user = id_user;
		this.email_user = email_user;
		this.nom_user = nom_user;
		this.img_user = img_user;
		this.listPlaylist = listPlaylist;
	}


	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getEmail_user() {
		return email_user;
	}

	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}

	public String getNom_user() {
		return nom_user;
	}

	public void setNom_user(String nom_user) {
		this.nom_user = nom_user;
	}

	public byte[] getImg_user() {
		return img_user;
	}

	public void setImg_user(byte[] img_user) {
		this.img_user = img_user;
	} 

	public List<Playlists> getListPlaylist() {
		return listPlaylist;
	}

	public void setListPlaylist(List<Playlists> listPlaylist) {
		this.listPlaylist = listPlaylist;
	}

	public void addPlaylist(Playlists playlist) {
		if(this.listPlaylist == null) {
			this.listPlaylist = new ArrayList<Playlists>();
		}
		this.listPlaylist.add(playlist);
		playlist.setUser(this);
	}

	public void removePlaylist(Playlists playlist) {
		if(this.listPlaylist == null) {
			this.listPlaylist = new ArrayList<Playlists>();
		}

		this.listPlaylist.remove(playlist);
		playlist.setUser(null);
	}

	@Override
	public String toString() {
		return "User [id=" + id_user + ", email_user=" + email_user + ", nom_user=" + nom_user + ", img_user=" + img_user + "]";
	}
}
