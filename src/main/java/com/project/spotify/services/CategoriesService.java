package com.project.spotify.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spotify.dao.CategoriesRepository;
import com.project.spotify.entity.Categories;
import com.project.spotify.entity.Titres;

@Service
public class CategoriesService {
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Categories> findAll()
	{
		return this.categoriesRepository.findAll();
	}
	
	public Optional<Categories> findById(int id)
	{	
		return  this.categoriesRepository.findById(id);
	}
	
	public Categories create(Categories categories) 
	{
		return this.categoriesRepository.save(categories);
	}
	
	public Categories update(Categories newCategories, Categories categories)
	{
		newCategories.setId_categorie(categories.getId_categorie());
		return this.categoriesRepository.save(newCategories);
	}
	
	public void delete(int id)
	{
		this.categoriesRepository.deleteById(id);
	}
	
	public List<Categories> findByString(String search){
		if(search.length() == 0) {
			return null;
		}
		return this.entityManager.createQuery("FROM Categories WHERE nom_categorie LIKE '%" + search + "%'").getResultList();
	}
}
