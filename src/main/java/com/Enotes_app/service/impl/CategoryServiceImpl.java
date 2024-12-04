package com.Enotes_app.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.Enotes_app.entity.Category;
import com.Enotes_app.repositories.CategoryRepository;
import com.Enotes_app.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public Boolean saveCategory(Category category) {
		category.setIsDeleted(false);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
    		Category saveCategory = categoryRepo.save(category);
    		if(ObjectUtils.isEmpty(saveCategory)) {
    			return false;
    		}
		return true;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> findAll = categoryRepo.findAll();
		return findAll;
	}
	
	

}
