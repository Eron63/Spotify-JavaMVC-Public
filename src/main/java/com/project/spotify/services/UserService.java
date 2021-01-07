package com.project.spotify.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spotify.dao.UserRepository;
import com.project.spotify.entity.Users;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EntityManager entityManager;
	
	public List<Users> findAll()
	{
		return this.userRepository.findAll();
	}
	
	public Optional<Users> findById(int id)
	{
		return this.userRepository.findById(id);
	}
	
	public Users findByName(String pseudo)
	{
		List<Users> users = this.entityManager.createQuery("FROM Users WHERE nom_user ='" + pseudo + "'").getResultList();
		if(users.isEmpty()) {
			return null;
		}

		return users.get(0);
	}
	
	public Users findByEmail(String email)
	{
		List<Users> users = this.entityManager.createQuery("FROM Users WHERE email_user ='" + email + "'").getResultList();
		if(users.isEmpty()) {
			return null;
		}
		System.out.println(users);

		return users.get(0);
	}
	
	public Users create(Users users) 
	{
		
		if(this.findByName(users.getNom_user()) != null || this.findByEmail(users.getEmail_user()) != null) {
			return null;
		}
		
		return this.userRepository.save(users);
	}
	
	public Users update(Users newUsers, Users users)
	{
		newUsers.setId_user(users.getId_user());
		return this.userRepository.save(newUsers);
	}
	
	public void delete(int id)
	{
		this.userRepository.deleteById(id);
	}
}
