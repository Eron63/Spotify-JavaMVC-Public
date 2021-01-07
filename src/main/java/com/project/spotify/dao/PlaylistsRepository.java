package com.project.spotify.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.spotify.entity.Playlists;

public interface PlaylistsRepository extends JpaRepository<Playlists, Integer>{

}