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
@Table(name = "specialite")
public class Specialite  extends AbstractEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5697691514160221155L;

	@Column(unique=true, nullable = false)
	private String labelle;
	
	@Column
	private String image;
	
    //aggregation specialite
	@OneToMany(mappedBy = "specialite"  ,cascade = CascadeType.PERSIST)
	private List<Cours> coursList; 
	
	
	//composition dicipline
	@ManyToOne
    @JoinColumn(name = "dicipline_id", nullable = false)
    private Dicipline dicipline;


	
	
	
	
	
	
	public String getLabelle() {
		return labelle;
	}


	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}


	public List<Cours> getCoursList() {
		return coursList;
	}


	public void setCoursList(List<Cours> coursList) {
		this.coursList = coursList;
	}


	public Dicipline getDicipline() {
		return dicipline;
	}


	public void setDicipline(Dicipline dicipline) {
		this.dicipline = dicipline;
	} 
	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}
	
}
