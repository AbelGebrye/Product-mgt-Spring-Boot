package com.abel.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abel.crud.example.entity.Product;
import com.abel.crud.example.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
		//saving a single product
	public Product saveProduct(Product product) {
		
	return repository.save(product);
	}
	
	//saving a multiple products
	public List<Product> saveProducts(List<Product> products) {
		
		return repository.saveAll(products);
		}
	
	//to get list  of all products
	public List<Product> getProducts(){
		
		List<Product> products = repository.findAll();
	
		return products;
	}
	
	//to get single product by id
   public Product getProductById(int id){
		
		return repository.findById(id).orElse(null);
	}
   
 //to get single product by name
   public List<Product> getProductByName(String name){
		
		return repository.findByNameLike("%"+name+"%");
	}
   
   
   //to delete a single product
   public String deleteProduct(int id){
		
		repository.deleteById(id);
		return "Product deleted by id || " + id;
		
	}
   
   public Product updateProduct(Product product) {
	   Product existingProduct = repository.findById(product.getId()).orElse(null);
	   existingProduct.setName(product.getName());
	   existingProduct.setQty(product.getQty());
	   existingProduct.setPrice(product.getPrice());
	   
	   return repository.save(existingProduct);
	 
   }
	
}
