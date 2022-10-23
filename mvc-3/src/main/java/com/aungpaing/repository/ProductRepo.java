package com.aungpaing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aungpaing.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
