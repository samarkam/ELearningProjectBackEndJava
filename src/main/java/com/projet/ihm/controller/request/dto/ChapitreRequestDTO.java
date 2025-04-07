package com.projet.ihm.controller.request.dto;

import com.projet.ihm.repo.model.Chapitre;

public class ChapitreRequestDTO {
	
	

	private String titre;
	
	private String description;
	    
    private int maxScore; 
	
    private int ordre;

    private Long coursId; 
    


	public ChapitreRequestDTO(String titre, String description, int maxScore, int ordre, Long coursId) {
		super();
		this.titre = titre;
		this.description = description;
		this.maxScore = maxScore;
		this.ordre = ordre;
		this.coursId = coursId;
	}



	public static ChapitreRequestDTO map(Chapitre chapitre) {
		return chapitre==null? null : new ChapitreRequestDTO(chapitre.getTitre(),chapitre.getDescription(),chapitre.getMaxScore(),chapitre.getOrdre(),chapitre.getCours().getId());
	}
	
	
	
	

	public Long getCoursId() {
		return coursId;
	}



	public void setCoursId(Long coursId) {
		this.coursId = coursId;
	}



	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

    
    
}
