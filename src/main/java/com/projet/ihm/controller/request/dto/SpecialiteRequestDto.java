package com.projet.ihm.controller.request.dto;

public class SpecialiteRequestDto {


	private Long diciplineId;

	private String labelle;
	
	private String image;
	
	
    
    
	
	public SpecialiteRequestDto(Long diciplineId, String labelle, String image) {
		super();
		this.diciplineId = diciplineId;
		this.labelle = labelle;
		this.image = image;
	}


	
	


	public Long getDiciplineId() {
		return diciplineId;
	}


	public void setDiciplineId(Long diciplineId) {
		this.diciplineId = diciplineId;
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


	
	
    
    
}
