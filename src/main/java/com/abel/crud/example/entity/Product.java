package com.abel.crud.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "Products")
public class Product {

	@Id
	@GeneratedValue
	private int id;
	public String name;
	private int qty;
	private double price;
	



	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	public int getQty() {
		// TODO Auto-generated method stub
		return qty;
	}

	public void setQty(int qty) {
		// TODO Auto-generated method stub
		this.qty= qty;
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	public void setPrice( double price) {
		// TODO Auto-generated method stub
		this.price = price;
	}
	
	
}
