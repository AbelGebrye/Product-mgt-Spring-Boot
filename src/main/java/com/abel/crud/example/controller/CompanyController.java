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

import com.abel.crud.example.entity.Company;
import com.abel.crud.example.service.CompanyService;

@CrossOrigin
@RestController
public class CompanyController {

	@Autowired
	public CompanyService service1;
	
	@PostMapping("/addcompany")
	public Company addCompany(@RequestBody Company company) {
		return service1.saveCompany(company);
	}
	
	
	@PostMapping("/addcompanys")
	public List<Company> addCompany(@RequestBody List<Company> company) {
		return service1.saveCompanys(company);
	}
	
	@GetMapping("/findcompany/{id}")
	public Company findCompany(@PathVariable int id) {
		return service1.findCompany(id);
		
	}
	@GetMapping("/findcompanys")
	public List<Company> findCompany() {
		return service1.findCompanys();
		
	}
	
	@GetMapping("/findcompanys/{name}")
	public List<Company> findCompanyByName( @PathVariable String name ){
		
		return service1.findCompanys(name);
		
	}
	
	
	@PutMapping("/updatecompany")
	public Company updateCompany(@RequestBody Company company) {
		
		return service1.updateCompany(company);
		
	}
	
	@DeleteMapping("/deletecompany/{id}")
	public List<Company> deleteCompany(@PathVariable int id) {
		service1.deleteCompany(id);
		return service1.findCompanys();
		
	}
	
}
