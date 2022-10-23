package com.aungpaing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aungpaing.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
