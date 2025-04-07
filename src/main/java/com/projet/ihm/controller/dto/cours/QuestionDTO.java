package com.projet.ihm.controller.dto.cours;

import java.util.List;

import com.projet.ihm.repo.model.Question;

public class QuestionDTO {

	
	 private Long id;
    private String enoncce;
    private String reponseCorrecte;
    private List<String> reponseIncorrecteList;
    private Long quizId;

   

	public QuestionDTO(Long id, String enoncce, String reponseCorrecte, List<String> reponseIncorrecteList,
			Long quizId) {
		super();
		this.id = id;
		this.enoncce = enoncce;
		this.reponseCorrecte = reponseCorrecte;
		this.reponseIncorrecteList = reponseIncorrecteList;
		this.quizId = quizId;
	}

	public static QuestionDTO map(Question question) {
		return question==null? null : new QuestionDTO(question.getId(),question.getEnoncce(),question.getReponseCorrecte(),
				question.getReponseIncorrecteList(),question.getQuiz().getId());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}
    
    

}
