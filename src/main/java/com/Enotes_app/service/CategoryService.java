package com.Enotes_app.service;

import java.util.List;

import com.Enotes_app.entity.Category;

public interface CategoryService {
	
	public Boolean saveCategory(Category category);
	public List<Category> getAllCategory();

}
