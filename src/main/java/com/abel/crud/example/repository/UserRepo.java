package com.abel.crud.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.abel.crud.example.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{

	User findByEmail(String userEmail);

}
