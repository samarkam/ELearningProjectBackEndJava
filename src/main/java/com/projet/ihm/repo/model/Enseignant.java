package com.projet.ihm.repo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("ENSEIGNANT")
public class Enseignant extends Utilisateur {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 3462152437526477788L;
	
	@Column(nullable = true)
	private String matricule;
	
	@Column(nullable = true)
	private String specialite;
	

	
	
	
    @OneToMany(mappedBy = "enseignant")
    private List<Cours> coursList;


    
    
    
    
    
    
    
    
    
    
    
    

	public String getMatricule() {
		return matricule;
	}



	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}



	public String getSpecialite() {
		return specialite;
	}



	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}






	public List<Cours> getCoursList() {
		return coursList;
	}



	public void setCoursList(List<Cours> coursList) {
		this.coursList = coursList;
	}
    
}
