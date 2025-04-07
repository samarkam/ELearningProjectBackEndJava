package com.projet.ihm.controller.request.dto;

public class CoursRequestDTO {

	
	
    private String titre;
    private String description;
    private String image;
    
    private String enseignantEmail; 
    private Long specialiteId;
	public CoursRequestDTO(String titre, String description, String image, String enseignantEmail, Long specialiteId) {
		super();
		this.titre = titre;
		this.description = description;
		this.image = image;
		this.enseignantEmail = enseignantEmail;
		this.specialiteId = specialiteId;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getEnseignantEmail() {
		return enseignantEmail;
	}
	public void setEnseignantEmail(String enseignantEmail) {
		this.enseignantEmail = enseignantEmail;
	}
	public Long getSpecialiteId() {
		return specialiteId;
	}
	public void setSpecialiteId(Long specialiteId) {
		this.specialiteId = specialiteId;
	} 
    
    
}
