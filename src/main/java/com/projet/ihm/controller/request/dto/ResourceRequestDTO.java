package com.projet.ihm.controller.request.dto;

public class ResourceRequestDTO {

	
	private Long chapitreId;
	
	
	private String titre;
	
	private String description;
	
	private String url;
	
	private  String typeRessource; // PDF,IMAGE,VIDEO

	

	public ResourceRequestDTO(Long chapitreId, String titre, String description, String url, String typeRessource) {
		super();
		this.chapitreId = chapitreId;
		this.titre = titre;
		this.description = description;
		this.url = url;
		this.typeRessource = typeRessource;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTypeRessource() {
		return typeRessource;
	}

	public void setTypeRessource(String typeRessource) {
		this.typeRessource = typeRessource;
	}

	public Long getChapitreId() {
		return chapitreId;
	}

	public void setChapitreId(Long chapitreId) {
		this.chapitreId = chapitreId;
	}
	
	
	
}
