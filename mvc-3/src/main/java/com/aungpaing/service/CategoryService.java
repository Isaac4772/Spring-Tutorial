package com.aungpaing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aungpaing.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo repo;

	public Object findAll() {
		return repo.findAll();
	}
}
