package com.project.spotify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.spotify.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
}
