package com.abel.crud.example.controller;

import java.util.Arrays;
import java.util.HashMap;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.abel.crud.example.entity.Product;

public class ProductClient {

	private static final String GET_ALL_PRODUCT_API = "http://localhost:9191/findproducts";
	private static final String GET_PRODUCTBYID_API = "http://localhost:9191/findproductid/{id}";
	private static final String UPDATE_PRODUCT_API = "http://localhost:9191/updateProduct";
	private static final String DELETE_PRODUCT_API = "http://localhost:9191/delete/{id}";
	private static final String ADD_PRODUCT_API = "http://localhost:9191/addProduct";
	//private static final String ADD_PRODUCTS_API = "http://localhost:9191/addProducts";

	static RestTemplate restTemplate = new RestTemplate();

	

	private static void getAllProduct() {

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_PRODUCT_API, HttpMethod.GET, entity,
				String.class);
		
	}

	private static void getProductById(int id) {

		Map<String, Integer> param = new HashMap<>();

		param.put("id", id);

		Product product = restTemplate.getForObject(GET_PRODUCTBYID_API, Product.class, param);

	

	}

	
	
	/*
	 * private static void createProducts() {
	 * 
	 * List<Product> Product(("Samsung J Prime", 8, 2000.0),("Samsung J Prime", 8,
	 * 2000.0));
	 * 
	 * ResponseEntity<Product> product2 =
	 * restTemplate.postForEntity(ADD_PRODUCTS_API, product, Product.class);
	 * 
	 * System.out.println(product2); }
	 */

	
	 
		public void deleteProduct(int id) {

			Map<String, Integer> param = new HashMap<>();

			param.put("id", id);

			restTemplate.delete(DELETE_PRODUCT_API, param);

		}
		
          

           }
