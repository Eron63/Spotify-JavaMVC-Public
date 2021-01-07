package com.project.spotify.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.spotify.entity.Users;
import com.project.spotify.exceptions.EmailException;
import com.project.spotify.exceptions.NomException;
import com.project.spotify.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="http://localhost:4200")
public class UserController 
{
	@Autowired
	UserService userService;

	@GetMapping("")
	public List<Users> findAllUsers()
	{
		return  this.userService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Users> findUsersById(@PathVariable(value = "id") int userId) 
	{
		return this.userService.findById(userId);
	}
	
	@GetMapping("/by-email/{email}")
	public Users findByEmail(@PathVariable(value="email") String email) 
	{
		return this.userService.findByEmail(email);
	}
	
	@PostMapping("")
	public Users createUsers(@RequestBody Users users) throws NomException, EmailException
	{
		Users userCheck1 = this.userService.findByName(users.getNom_user());
		Users userCheck2 = this.userService.findByEmail(users.getEmail_user());

		if(userCheck1 != null) {
			throw new NomException(users.getNom_user());
		}
		
		if(userCheck2 != null) {
			throw new EmailException(users.getEmail_user());
		}
				
		return this.userService.create(users);
	}
	
	@PutMapping("/{id}")
	public Users updateUsers(@PathVariable(value="id") int id, @RequestBody Users newUsers)
	{
		Users users = this.userService.findById(id).get();
		return this.userService.update(newUsers, users);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsers(@PathVariable(value="id") int id)
	{
		this.userService.delete(id);
	}
}
