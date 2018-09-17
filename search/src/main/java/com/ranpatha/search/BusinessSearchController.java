package com.ranpatha.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranpatha.search.model.Company;
import com.ranpatha.search.service.BusinessSearchRepository;

@RestController
@RequestMapping(path="/businessSearch")
public class BusinessSearchController {
	
	
	@Autowired
	private BusinessSearchRepository businessSearchRepo;
	
	@GetMapping("/getcategories")
	public List<Company> getCategories(){
		List<Company> abc = businessSearchRepo.findAllCategories();
		System.out.println("Categories size is :: "+abc.size());
		return abc;
	}
	
	@GetMapping("/getSubcategories/{category}")
	public List getSubCategoryforCategoryCategories(@PathVariable("category") String category){
		List<Company> abc = businessSearchRepo.findSubCategoryByCategoryName(category);
		System.out.println("SubCategories size is :: "+abc.size());
		return abc;
	}
	
	@GetMapping("/{category}/getCompany/{subCategory}")
	public List getCompaniesforSubCategory(@PathVariable("category") String category,@PathVariable("subCategory") String subCategory){
		List<Company> abc = businessSearchRepo.findCompniesforSubCategory(category, subCategory);
		System.out.println("SubCategories size is :: "+abc.size());
		return abc;
	}
	
	
	

}
