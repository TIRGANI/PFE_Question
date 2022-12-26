package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Question_Reponces;


public interface Question_ReponceRepository extends JpaRepository<Question_Reponces, Integer>{
	
}
