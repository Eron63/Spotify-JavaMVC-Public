package com.project.spotify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.spotify.entity.Albums;

@Repository
public interface AlbumsRepository extends JpaRepository<Albums, Integer>{

}
