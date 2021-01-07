package com.project.spotify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.spotify.entity.Titres;

@Repository
public interface TitresRepository extends JpaRepository<Titres, Integer>{

}
