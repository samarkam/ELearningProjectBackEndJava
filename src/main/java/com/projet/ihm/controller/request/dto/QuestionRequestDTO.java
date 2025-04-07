package com.projet.ihm.controller.request.dto;

import java.util.List;

public class QuestionRequestDTO {

	
    private String enoncce;
    private String reponseCorrecte;
    private List<String> reponseIncorrecteList;

   

	public QuestionRequestDTO( String enoncce, String reponseCorrecte, List<String> reponseIncorrecteList) {
		super();
		this.enoncce = enoncce;
		this.reponseCorrecte = reponseCorrecte;
		this.reponseIncorrecteList = reponseIncorrecteList;
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

	
}
