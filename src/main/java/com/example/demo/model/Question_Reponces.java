package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="question_reponces")
public class Question_Reponces {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Question question;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Reponce reponce;
	public Question_Reponces(int id,Question question, Reponce reponce) {
		this.id=id;
		this.question = question;
		this.reponce = reponce;
	}
	
	public Question_Reponces() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Reponce getReponce() {
		return reponce;
	}

	public void setReponce(Reponce reponce) {
		this.reponce = reponce;
	}
	
	
}
