package com.projet.ihm.controller.request.dto;

public class DiciplineRequestDTO {

	


	private String titre;
	
	private String description;

	private String image;
	

	public DiciplineRequestDTO( String titre, String description, String image) {
		super();

		this.titre = titre;
		this.description = description;
		this.image = image;
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
	
	
	
}
