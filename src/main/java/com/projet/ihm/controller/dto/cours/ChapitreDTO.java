package com.projet.ihm.controller.dto.cours;

import java.util.List;
import java.util.stream.Collectors;

import com.projet.ihm.repo.model.Chapitre;

public class ChapitreDTO {
	
	
	private Long id;

	private String titre;
	
	private String description;
	    
    private int maxScore; 
	
    private int ordre;
    private List<ResourceDTO> resourceList;
    private QuizDTO quiz ;

    
    
	

	public ChapitreDTO(Long id, String titre, String description, int maxScore, int ordre,
			List<ResourceDTO> resourceList, QuizDTO quiz) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.maxScore = maxScore;
		this.ordre = ordre;
		this.resourceList = resourceList;
		this.quiz = quiz;
	}



	public static ChapitreDTO map(Chapitre chapitre) {
		return chapitre==null? null : new ChapitreDTO(chapitre.getId(),chapitre.getTitre(),chapitre.getDescription(),chapitre.getMaxScore(),chapitre.getOrdre(),null,null);
	}
	public static ChapitreDTO mapWithQuiz(Chapitre chapitre) {
		return chapitre==null? null : new ChapitreDTO(chapitre.getId(),chapitre.getTitre(),chapitre.getDescription(),chapitre.getMaxScore(),chapitre.getOrdre(),null,QuizDTO.map(chapitre.getQuiz()));
	}
	public static ChapitreDTO mapWithResourceList(Chapitre chapitre) {
		return chapitre==null? null : new ChapitreDTO(chapitre.getId(),chapitre.getTitre(),chapitre.getDescription(),chapitre.getMaxScore(),chapitre.getOrdre(),
				chapitre.getRessourceList() == null ? null : chapitre.getRessourceList().stream().map(ResourceDTO::map).collect(Collectors.toList()),null);
	}
	
	
	public List<ResourceDTO> getResourceList() {
		return resourceList;
	}



	public void setResourceList(List<ResourceDTO> resourceList) {
		this.resourceList = resourceList;
	}



	public QuizDTO getQuiz() {
		return quiz;
	}



	public void setQuiz(QuizDTO quiz) {
		this.quiz = quiz;
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
