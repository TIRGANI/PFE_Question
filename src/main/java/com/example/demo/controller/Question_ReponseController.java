package com.example.demo.controller;

import java.util.ArrayList;
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
import com.example.demo.model.Question_Reponces;
import com.example.demo.model.Reponce;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.Question_ReponceRepository;
import com.example.demo.repository.ReponceRepository;

@RestController
@RequestMapping("question_Reponces")
public class Question_ReponseController {
	@Autowired
	private Question_ReponceRepository question_ReponceRepository;
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private ReponceRepository reponceRepository;
	@GetMapping("/all")
	public List<Question_Reponces> findAll() {
		return question_ReponceRepository.findAll();
	}
	@PostMapping("/save/{id_rep}/{id_qus}")
	public boolean save(@PathVariable int id_rep,@PathVariable int id_qus) {
		
		Question q = new Question();
		for (Question qi: questionRepository.findAll()) {
			if(qi.getId()==id_rep) {
				q.setId(qi.getId());
				q.setDesc(qi.getDesc());
				
			}
		}
		Reponce r = new Reponce();
		for (Reponce qi: reponceRepository.findAll()) {
			if(qi.getId()==id_qus) {
				r.setId(qi.getId());
				r.setDesc(qi.getDesc());

			}
		}if(q.getDesc()!=null && r.getDesc()!=null) {
			question_ReponceRepository.save(new Question_Reponces(1,q,r));
			return true;
		}
		return false;
	}
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		question_ReponceRepository.deleteById(id);
	}
	@PostMapping("/question/{question}")
	public List<String> question(@PathVariable String question) {
		List<String> ques = new ArrayList<>();
		for (Question q: questionRepository.findAll()) {
			if (q.getDesc().contains(question)){
				ques.add(q.getDesc());
			}
		}
		return ques;
	}
	}
