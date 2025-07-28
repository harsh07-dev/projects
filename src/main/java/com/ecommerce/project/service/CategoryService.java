package com.ecommerce.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.project.controller.repository.CategoryRepository;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.myGlobalExceptionHnadler.APIException;
import com.ecommerce.project.myGlobalExceptionHnadler.ResourceNotFoundException;
import com.ecommerce.project.payloadDTO.CategoryDTO;
import com.ecommerce.project.payloadDTO.CategoryResponse;
import java.util.stream.Collectors;

import ch.qos.logback.classic.Logger;
import jakarta.transaction.Transactional;

@Service
public class CategoryService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CategoryRepository categoryRepository;
	private static final Logger logger = (Logger) LoggerFactory.getLogger(CategoryService.class);

	// creating a array list of type category to store the values.
	private List<Category> categories = new ArrayList<>();

	private long nextid = 0L;


	public void createCategory(Category category) {

		logger.info("inside service layer method ");		
		Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
		if (savedCategory != null) {
			throw new APIException("Category with the name " + category.getCategoryName() + " already exists !!!");
		}

		categories.add(category);
		categoryRepository.save(category);

	}

	public void createCategory1(List<Category> category) {
		// TODO Auto-generated method stub
		logger.info("inside service layer method ");

//  add all method is use to save the list without using for loop
// categories.addAll(category);

// System.out.print(category.getCategoryId() +"checking");;

// validation for the value of id .
		for (Category c : category) {
			{
				c.setCategoryId(nextid++);
				if (c.getCategoryId() != 0) {
					categories.add(c);
					categoryRepository.save(c);

				}
			}

		}

	}


	public CategoryResponse printall(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
		Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
		// to check if the category list is empty or not
		/*
		 * implemating pagination
		 */

		Pageable pageDetails = PageRequest.of(pageNumber, pageSize,sortByAndOrder);
		Page<Category> categoryPage = categoryRepository.findAll(pageDetails);

		// List<Category> cat = categoryRepository.findAll();
		List<Category> cat = categoryPage.getContent();
		if (cat.isEmpty()) {
			throw new APIException("No category added till now");
		}
		List<CategoryDTO> categoryDTOS = cat.stream().map(category -> {
			CategoryDTO dto = modelMapper.map(category, CategoryDTO.class);
			dto.setName("harshchanges"); // set the name manually
			return dto;
		}).toList();

		CategoryResponse categoryResponse = new CategoryResponse();
		categoryResponse.setPageNumebr(pageNumber);
		categoryResponse.setPageSize(pageSize);
		categoryResponse.setTotalElements(categoryPage.getTotalElements());
		categoryResponse.setTotalPages(categoryPage.getTotalPages());
		categoryResponse.setLastPage(categoryPage.isLast());

		categoryResponse.setContent(categoryDTOS);

		return categoryResponse;
	}

	public String deleteCategorie(Long categoryId) {

		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

//		Category category = categories.stream().filter(c -> c.getCategoryId().equals(categoryId)).findFirst()
//				.orElse(null);
//
//		if (category == null) {
//			return "category id not prenst";
//		}
//
//		categories.remove(category);
		categoryRepository.delete(category);
//		
//
		return "category if removed suceessfully " + categoryId;
	}

	// this is the old code
//	public Category updateCategory(Category category, Long categoryId) {
//		// TODO Auto-generated method stub
//
//		Optional<Category> updatecategory = categories.stream().filter(c -> c.getCategoryId().equals(categoryId))
//				.findFirst();
//		if (!updatecategory.isEmpty()) {
//			Category existingCategory = updatecategory.get();
//			existingCategory.setCategoryName(category.getCategoryName());
//			return existingCategory;
//		} else
//			throw new  ResourceNotFoundException("Category","categoryId",categoryId);
//
//	}

	/*
	 * again i am doinG some changes based on the DTO
	 */
	public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {
		Category savedCategory = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

		Category category = modelMapper.map(categoryDTO, Category.class);
		category.setCategoryId(categoryId);
		savedCategory = categoryRepository.save(category);
		CategoryDTO updatedCategoryDTO = modelMapper.map(savedCategory, CategoryDTO.class);
		updatedCategoryDTO.setName("chages_done_by_harsh");
		return updatedCategoryDTO;
	}
}
