package com.ecommerce.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;

import jakarta.validation.Valid;

//@RestController
//public class Check {
//	@Autowired
//	CategoryService categoryService;
//
//	@PostMapping("/categori")
//
//	// @Valid anotation is used to get the error responce
//
//	public String createCategory(@Valid @RequestBody Category category) {
//		categoryService.createCategory(category);
//
//		return "single category added";
//
//	}
//}
