package com.projet.ihm.controller.dto.cours;

import com.projet.ihm.repo.model.Ressource;

public class ResourceDTO {

	
	private Long id;	
	
	private String titre;
	
	private String description;
	
	private String url;
	
	private  String typeRessource; // PDF,IMAGE,VIDEO

	

	public ResourceDTO(Long id, String titre, String description, String url, String typeRessource) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.url = url;
		this.typeRessource = typeRessource;
	}
	
	public static ResourceDTO map(Ressource ressource) {
		return ressource == null ? null : new ResourceDTO(ressource.getId(),ressource.getTitre(),ressource.getDescription(),ressource.getUrl(),ressource.getTypeRessource().toString());
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



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	
	
	
}
