package com.abel.crud.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abel.crud.example.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

	List<Product> findByNameLike(String name);


}
