package com.ecommerce.project.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.project.model.Product;

@Repository

public interface ProductRepo extends JpaRepository<Product, Long> {

	
	@Query(value=" select  P.* from PRODUCT P join  CATEGORY  c on c.CATEGORY_ID =P.CATEGORY_ID where c.CATEGORY_ID = :categoryId",nativeQuery = true)
	List<Product> findProductByCustomerId( @Param("categoryId") Long categoryId);
	


}
