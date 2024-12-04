package com.Enotes_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Enotes_app.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
