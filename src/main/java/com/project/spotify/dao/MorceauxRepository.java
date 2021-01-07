package com.project.spotify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.spotify.entity.Morceaux;

@Repository
public interface MorceauxRepository extends JpaRepository<Morceaux, Integer>{

}
