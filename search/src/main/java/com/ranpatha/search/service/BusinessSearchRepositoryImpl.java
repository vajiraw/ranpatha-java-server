package com.ranpatha.search.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ranpatha.search.model.Company;

@Repository
public class BusinessSearchRepositoryImpl implements BusinessSearchRepository{
	
	@Autowired
	  private MongoTemplate mongoTemplate;
	
	@Override
	public Company findByName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> findDistinctSubCategoryByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<Company> findAllCategories() {		
			
		   Query query = new Query();		   
		   List<Company>  companies = mongoTemplate.find(query, Company.class);		   
		   
		   Map<String,Company> map = new HashMap<String,Company>();   		   
		   companies.forEach(company ->
		   					{		   					
		   					 map.put(company.getCategory(), company);});
		   
		   List<Company> lstCompany =  new ArrayList<Company>();
		   
		   map.forEach((k,v)->{ lstCompany.add(v);});		   
		   return lstCompany;
		   
		   //return (List<Company>) mongoTemplate.findOne(query, Company.class);
	}
	

	@Override
	public List<Company> findSubCategoryByCategoryName(String category) {
			System.out.println("category to get sub categories:: "+category);
			
		   Query query = new Query();
		   query.addCriteria(Criteria.where("category").is(category));
		   List<Company>  companies = mongoTemplate.find(query, Company.class);
		   
		   
		   Map<String,Company> map = new HashMap<String,Company>();   		   
		   companies.forEach(company ->
		   					{		   					
		   					 map.put(company.getSubCategory(), company);});
		   
		   List<Company> lstCompany =  new ArrayList<Company>();
		   
		   map.forEach((k,v)->{ lstCompany.add(v);});		   
		   return lstCompany;
		   		   
	}
	
	
	@Override
	public List<Company> findCompniesforSubCategory(String category,String subCategory) {
			System.out.println("category to get sub categories:: "+category + "sub category "+subCategory);
			
		   Query query = new Query();
		   query.addCriteria(Criteria.where("category").is(category));
		   query.addCriteria(Criteria.where("subCategory").is(subCategory));
		   List<Company>  companies = mongoTemplate.find(query, Company.class);
		   
		   
		   //Map<String,Company> map = new HashMap<String,Company>();   		   
		  /* companies.forEach(company ->
		   					{		   					
		   					 map.put(company.getSubCategory(), company);});
		   
		   List<Company> lstCompany =  new ArrayList<Company>();*/
		   
		  // map.forEach((k,v)->{ lstCompany.add(v);});		   
		   return companies;
		   		   
	}
	
	
	

}
