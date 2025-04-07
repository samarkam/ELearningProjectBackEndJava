package com.projet.ihm.controller.dto.cours;

import java.util.Map;

public class QuizSubmissionDTO {

	
	private Long etudiantId;
	private Long quizId;
    private Map<Long, String> answers; // Question ID -> Student's answer

    

	public QuizSubmissionDTO(Long etudiantId, Long quizId, Map<Long, String> answers) {
		super();
		this.etudiantId = etudiantId;
		this.quizId = quizId;
		this.answers = answers;
	}

	public Long getEtudiantId() {
		return etudiantId;
	}

	public void setEtudiantId(Long etudiantId) {
		this.etudiantId = etudiantId;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public Map<Long, String> getAnswers() {
		return answers;
	}

	public void setAnswers(Map<Long, String> answers) {
		this.answers = answers;
	}
    
    
}
