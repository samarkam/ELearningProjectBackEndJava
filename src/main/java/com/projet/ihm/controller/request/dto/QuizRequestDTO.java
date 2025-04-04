package com.projet.ihm.controller.request.dto;

import java.util.List;

public class QuizRequestDTO {

	
   private Long id;
    private String titre;
    private Long chapitreId;
    private List<QuestionRequestDTO> questions;




	public QuizRequestDTO(Long id, String titre, Long chapitreId, List<QuestionRequestDTO> questions) {
		super();
		this.id = id;
		this.titre = titre;
		this.chapitreId = chapitreId;
		this.questions = questions;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Long getChapitreId() {
		return chapitreId;
	}

	public void setChapitreId(Long chapitreId) {
		this.chapitreId = chapitreId;
	}

	public List<QuestionRequestDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionRequestDTO> questions) {
		this.questions = questions;
	}
    
    
    
    
}
