package com.project.spotify.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.spotify.entity.Categories;
import com.project.spotify.services.CategoriesService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoriesService categoriesService;
	
	@GetMapping("")
	public List<Categories> findAll()
	{
		return this.categoriesService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Categories> findById(@PathVariable(value="id") int id)
	{
		return this.categoriesService.findById(id);
	}
}
