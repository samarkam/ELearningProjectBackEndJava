package com.projet.ihm.repo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "question")
public class Question  extends AbstractEntity{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2285156831442367450L;

	@Column(nullable = false)
	private String enoncce;
	
	@Column(name="reponse_correcte", nullable = false)
	private String reponseCorrecte;

	@Column(name="reponse_incorrecte_list", nullable = false)
	private List<String> reponseIncorrecteList;


	//composition Question
	@ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

	
	
	
	
	
	
	
	
	

	public String getEnoncce() {
		return enoncce;
	}


	public void setEnoncce(String enoncce) {
		this.enoncce = enoncce;
	}


	public String getReponseCorrecte() {
		return reponseCorrecte;
	}


	public void setReponseCorrecte(String reponseCorrecte) {
		this.reponseCorrecte = reponseCorrecte;
	}


	public List<String> getReponseIncorrecteList() {
		return reponseIncorrecteList;
	}


	public void setReponseIncorrecteList(List<String> reponseIncorrecteList) {
		this.reponseIncorrecteList = reponseIncorrecteList;
	}


	public Quiz getQuiz() {
		return quiz;
	}


	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	} 
	
	
}
