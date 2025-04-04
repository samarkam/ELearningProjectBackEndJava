package com.projet.ihm.controller.dto.cours;

import java.util.List;
import java.util.stream.Collectors;

import com.projet.ihm.repo.model.Quiz;

public class QuizDTO {

	
   private Long id;
    private String titre;
    private Long chapitreId;
    private List<QuestionDTO> questions;




	public QuizDTO(Long id, String titre, Long chapitreId, List<QuestionDTO> questions) {
		super();
		this.id = id;
		this.titre = titre;
		this.chapitreId = chapitreId;
		this.questions = questions;
	}

	public static QuizDTO map(Quiz quiz) {
		return quiz==null? null : new QuizDTO(quiz.getId(),quiz.getTitre(),quiz.getChapitre().getId(),
				quiz.getQuestionList() == null ? null : quiz.getQuestionList().stream().map(QuestionDTO::map).collect(Collectors.toList()));
	}
	public static QuizDTO mapWithQuestions(Quiz quiz) {
		return quiz==null? null : new QuizDTO(quiz.getId(),quiz.getTitre(),quiz.getChapitre().getId(),
				quiz.getQuestionList() == null ? null : quiz.getQuestionList().stream().map(QuestionDTO::map).collect(Collectors.toList()));
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

	public List<QuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDTO> questions) {
		this.questions = questions;
	}
    
    
    
    
}
