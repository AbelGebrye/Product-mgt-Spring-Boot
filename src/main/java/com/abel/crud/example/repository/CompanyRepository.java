package com.abel.crud.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abel.crud.example.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	List<Company> findCompanyByNameLike(String name);

}
