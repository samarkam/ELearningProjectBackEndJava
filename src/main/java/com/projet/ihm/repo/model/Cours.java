package com.projet.ihm.repo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cours")
public class Cours  extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7313384478701233631L;

	@Column(nullable=false, unique=true)
	private String titre;
	
	@Column
	private String description;
	
	@Column
	private String image;
	
	@Column 
	private boolean isPublished =false; // changes by enseignant 
	
	
	@Column 
	private boolean isActive =true; // changes by Admin 
	    
	@Column(nullable=false)
    private int maxScore; 
	
    @OneToMany(mappedBy = "cours")
    private List<InscriptionCours> inscriptionCoursList;

    
    @ManyToOne
    @JoinColumn(name = "enseignant_id", nullable = true)
    private Enseignant enseignant; 
    
    //aggregation specialite
    @ManyToOne
    @JoinColumn(name = "specialite_id", nullable = false)
    private Specialite specialite; 
  
    
    
	//composition Cours
	@OneToMany(mappedBy = "cours", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Chapitre> chapitreList;


	
	
	
	
	
	
	
	
	
	
	
	

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



	public List<InscriptionCours> getInscriptionCoursList() {
		return inscriptionCoursList;
	}



	public void setInscriptionCoursList(List<InscriptionCours> inscriptionCoursList) {
		this.inscriptionCoursList = inscriptionCoursList;
	}



	public Enseignant getEnseignant() {
		return enseignant;
	}



	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}



	public Specialite getSpecialite() {
		return specialite;
	}



	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}



	public List<Chapitre> getChapitreList() {
		return chapitreList;
	}



	public void setChapitreList(List<Chapitre> chapitreList) {
		this.chapitreList = chapitreList;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public boolean isPublished() {
		return isPublished;
	}



	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}
	

}
