package com.ranpatha.search.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ranpatha.search.model.Company;

public interface BusinessSearchRepository  { //extends MongoRepository<Company, String>
	
	 public Company findByName(String firstName);
	 public List<Company> findDistinctSubCategoryByCategory(String category);
	 public List<Company> findSubCategoryByCategoryName(String category);
	List<Company> findAllCategories();
	List<Company> findCompniesforSubCategory(String category, String subCategory);
	 
	 //public List<Customer> findByLastName(String lastName);
	 
	 /*@Query(value="{}", fields="{subCategory : 1,category : 1, _id : 0}")
	 List<Company> findSubCategoriesForCategory(String category);*/
	 

}
