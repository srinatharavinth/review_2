package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Products;

public interface ProdcutRepository extends JpaRepository<Products, Integer>{

}
