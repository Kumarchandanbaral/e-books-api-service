package com.Enotes_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Enotes_app.entity.Category;
import com.Enotes_app.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	
	//http://localhost:3306/api/v1/category/save-category

	//http://localhost:3306/api/v1/category/categories
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/save-category")
	public ResponseEntity<?>saveCategory(@RequestBody Category category){
		
	    Boolean saveCategory = categoryService.saveCategory(category);
	    if(saveCategory) {
	    	
	    	return new ResponseEntity<>("save",HttpStatus.CREATED);
	    }
	    else {
	    	return new ResponseEntity<>("not save",HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/categories")
	public ResponseEntity<?>getAllCategory(){
		
		List<Category> allCategory = categoryService.getAllCategory();
		if(org.springframework.util.CollectionUtils.isEmpty(allCategory)) {
			
			return ResponseEntity.noContent().build();
		}
		else {
			
			return new ResponseEntity<>(allCategory,HttpStatus.OK);
		}
	}
	
}
