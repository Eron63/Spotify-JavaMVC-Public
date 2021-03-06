package com.project.spotify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.spotify.entity.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer>{

}
