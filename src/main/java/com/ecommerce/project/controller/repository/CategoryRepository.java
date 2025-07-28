package com.ecommerce.project.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
 // HERE THE jPA will automatically find the category name we dont have to write the 
// sql scrit y our own .	
	Category findByCategoryName(String categoryName);

}