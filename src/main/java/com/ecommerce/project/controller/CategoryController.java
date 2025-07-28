
package com.ecommerce.project.controller;

import java.util.ArrayList;
import java.util.List;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.project.config.AppConstants;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payloadDTO.CategoryDTO;
import com.ecommerce.project.payloadDTO.CategoryResponse;
import com.ecommerce.project.service.CategoryService;

@RestController
@RequestMapping("/api/public")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	// used to get the JSON as output.
	// implementing Pagination
	@GetMapping("/categories")
	public ResponseEntity<CategoryResponse> getAllCategories(@RequestParam(name = "pageNumber") Integer pageNumber,
			@RequestParam(name = "pageSize") Integer pageSixe,
			@RequestParam(name="sortBy",defaultValue = AppConstants.SORT_CATEGORIES_BY, required = false)String sortBy,
			@RequestParam(name="sortOrder",defaultValue = AppConstants.SORT_DIR, required = false )String sortOrder) {
		logger.info("inside get method");
		CategoryResponse categoryResponse = categoryService.printall(pageNumber,pageSixe,sortBy,sortOrder);

		return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
	}

	// code to add list of categories
	@PostMapping("/categories")

	public String createCategory(@Valid @RequestBody List<Category> category) {
		// yha pr for loop mai hm 1 1 // code to add list of categories pass kr rhe
		// hai and then passin to the serive method createCategory
		for (Category category1 : category) {

			categoryService.createCategory(category1);
		}

		return "category addd successfully";

	}

	
	@PostMapping("/check")

	public String createCategory1(@RequestBody List<Category> category) {

		categoryService.createCategory1(category);

		return "category addd successfully for list";

	}

	
	

	/*code to add single categorie, we can not pass the json
	 *  inside the []
	 *  @Valid annotation checks the validation on the 
	 *  category object before the controller logic runs
	 */
	
	
	@PostMapping("/categorie")
	public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
		categoryService.createCategory(category);

		logger.info("id" + category.getCategoryId());
		return new ResponseEntity<>("Category added sucessfully",HttpStatus.OK);

	}

// deleting the category
	@DeleteMapping("/categories/{categoryId}")

	public String deleteCategorie(@PathVariable Long categoryId) {

		String Status = categoryService.deleteCategorie(categoryId);
		return Status;
	}

	// updating the category
	
	//learnign git 

	@PutMapping("/categories/{categoryId}")

	public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDto,
			@PathVariable Long categoryId) {

		CategoryDTO saveCategory = categoryService.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<>(saveCategory, HttpStatus.OK);
	}

}