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
	
	@GetMapping("/getSubcategories/{category}")
	public List getCategories(@PathVariable("category") String category){
		List<Company> abc = businessSearchRepo.findSubCategoryByCategoryName(category);
		System.out.println("size is :: "+abc.size());
		return abc;
	}

}
