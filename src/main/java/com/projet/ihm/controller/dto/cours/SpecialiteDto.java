package com.projet.ihm.controller.dto.cours;

import java.util.List;
import java.util.stream.Collectors;

import com.projet.ihm.repo.model.Specialite;

public class SpecialiteDto {


	private Long id;

	private String labelle;
	
	private String image;
	
	private List<CoursDTO> coursList; 
	
    private DiciplineDTO dicipline;
    
    
	
	public SpecialiteDto(Long id, String labelle, String image, List<CoursDTO> coursList, DiciplineDTO dicipline) {
		super();
		this.id = id;
		this.labelle = labelle;
		this.image = image;
		this.coursList = coursList;
		this.dicipline = dicipline;
	}


	public static SpecialiteDto map(Specialite specialite) {
		return specialite == null ? null : new SpecialiteDto(specialite.getId(),specialite.getLabelle(),specialite.getImage()
				,null
				,specialite.getDicipline() == null ? null : DiciplineDTO.map(specialite.getDicipline()));
	}
	public static SpecialiteDto mapWithCourslist(Specialite specialite) {
		return specialite == null ? null : new SpecialiteDto(specialite.getId(),specialite.getLabelle(),specialite.getImage()
				,specialite.getCoursList()==null ?null : specialite.getCoursList().stream().map(CoursDTO::map).collect(Collectors.toList())
				,specialite.getDicipline() == null ? null : DiciplineDTO.map(specialite.getDicipline()));
	}
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getLabelle() {
		return labelle;
	}



	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public List<CoursDTO> getCoursList() {
		return coursList;
	}



	public void setCoursList(List<CoursDTO> coursList) {
		this.coursList = coursList;
	}



	public DiciplineDTO getDicipline() {
		return dicipline;
	}



	public void setDicipline(DiciplineDTO dicipline) {
		this.dicipline = dicipline;
	}

	
	
	
    
    
}
