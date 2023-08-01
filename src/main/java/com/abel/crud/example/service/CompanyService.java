package com.abel.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abel.crud.example.entity.Company;
import com.abel.crud.example.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository1;
	
	//saving company data
	public Company saveCompany(Company company) {
		return repository1.save(company);
	}
	
	//saving list of company data
		public List<Company> saveCompanys(List<Company> company) {
			return repository1.saveAll(company);
		}
		
		//getting list of company
		public List<Company> findCompanys() {
			return repository1.findAll();
		}	
		
		//getting single company data
		public Company findCompany(int id) {
			return repository1.findById(id).orElse(null);
		}
		
		
		//Delete by id
		public String deleteCompany(int id) {
			repository1.deleteById(id);
			return "Successfully Deleted the ID ||" + id;
		}
		
		
		//update company
		public Company updateCompany(Company company) {
			
			Company existingCompany = repository1.findById(company.getId()).orElse(null);
			
			existingCompany.setName(company.getName());
			existingCompany.setDescrption(company.getDescrption());
			
			return repository1.save(existingCompany);
	
		}

		public List<Company> findCompanys(String name) {
			// TODO Auto-generated method stub
			return repository1.findCompanyByNameLike("%"+name+"%");
		}
}
