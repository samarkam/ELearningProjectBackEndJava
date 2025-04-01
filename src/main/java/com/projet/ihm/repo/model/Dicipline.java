package com.projet.ihm.repo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dicipline")
public class Dicipline  extends AbstractEntity{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9039491629176886495L;

	@Column(unique=true, nullable = false)
	private String titre;
	
	@Column( nullable = false)
	private String description;

	@Column
	private String image;
	
	//composition dicipline
	@OneToMany(mappedBy = "dicipline", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Specialite> specialiteList;


	
	
	
	
	
	
	
	
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


	public List<Specialite> getSpecialiteList() {
		return specialiteList;
	}


	public void setSpecialiteList(List<Specialite> specialiteList) {
		this.specialiteList = specialiteList;
	}
	
	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}
}
