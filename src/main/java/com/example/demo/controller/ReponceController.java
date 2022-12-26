package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Question;
import com.example.demo.model.Reponce;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.ReponceRepository;

@RestController
@RequestMapping("reponce")
public class ReponceController {
	@Autowired
	private ReponceRepository reponceRepository;
	
	@GetMapping("/all")
	public List<Reponce> findAll() {
		return reponceRepository.findAll();
	}
	@PostMapping(value = "/save")
	public void save(@RequestBody final Reponce reponce) {
		reponceRepository.save(reponce);
	}
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		reponceRepository.deleteById(id);
	}

}
