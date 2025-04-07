package com.projet.ihm.controller.dto.cours;

import java.util.List;
import java.util.stream.Collectors;

import com.projet.ihm.repo.model.Dicipline;

public class DiciplineDTO {

	
	private Long id;

	private String titre;
	
	private String description;

	private String image;
	
	private List<SpecialiteDto> specialiteList;

	public DiciplineDTO(Long id, String titre, String description, String image, List<SpecialiteDto> specialiteList) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.image = image;
		this.specialiteList = specialiteList;
	}

	
	
	public static DiciplineDTO map(Dicipline dicipline) {
		return dicipline == null ? null : new DiciplineDTO(dicipline.getId(),dicipline.getTitre(),dicipline.getDescription(),dicipline.getImage()
				,null);
	}
	public static DiciplineDTO mapWithSpecialiteList(Dicipline dicipline) {
		return dicipline == null ? null : new DiciplineDTO(dicipline.getId(),dicipline.getTitre(),dicipline.getDescription(),dicipline.getImage()
				,dicipline.getSpecialiteList()==null ?null : dicipline.getSpecialiteList().stream().map(SpecialiteDto::map).collect(Collectors.toList()) );
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<SpecialiteDto> getSpecialiteList() {
		return specialiteList;
	}

	public void setSpecialiteList(List<SpecialiteDto> specialiteList) {
		this.specialiteList = specialiteList;
	}
	
	
	
	
}
