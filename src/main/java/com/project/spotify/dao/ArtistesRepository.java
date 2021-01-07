package com.project.spotify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.spotify.entity.Artistes;

@Repository
public interface ArtistesRepository extends JpaRepository<Artistes, Integer>{

}
