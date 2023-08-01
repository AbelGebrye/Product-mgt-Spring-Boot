package com.abel.crud.example.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abel.crud.example.entity.Product;
import com.abel.crud.example.service.ProductService;

@CrossOrigin
@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	
	public static String uploadDirectory = "../F:/Angular Projects/product-client/src/app/productimg";

	@PostMapping("/addProduct")
	public List<Product> addProduct(@RequestBody Product product) {
		
		
		service.saveProduct(product);
		return service.getProducts();
		
	}
	
	@PostMapping("/addProducts")
public List<Product> addProducts(@RequestBody List<Product> products) {
		
		
		return service.saveProducts(products);
		
	}
	

	@GetMapping("/findproducts")
public List<Product> findProducts() {
		
		return service.getProducts();
		
	}

	@GetMapping("/findproductid/{id}")
  public Product findproductById(@PathVariable int id) {
	
	 
	return service.getProductById(id);
	
	
}
 
	@GetMapping("/findproductname/{name}")
   public List<Product> findproductByName(@PathVariable String name) {
	
	return service.getProductByName(name);
	
}

	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		
		return service.updateProduct(product);
		
	}
	
	@DeleteMapping("/delete/{id}")
	   public List<Product> deleteProduct(@PathVariable int id) {
		
		service.deleteProduct(id);
		
		return service.getProducts();
		
	}
}
