package com.projet.ihm.repo.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("ETUDIANT")
public class Etudiant extends Utilisateur {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6429947650076680272L;

	@Column(name="niveau_etude",nullable = true)
    private String niveauEtude;
	

	
    @OneToMany(mappedBy = "etudiant")
    private Set<InscriptionCours> inscriptionCoursList;

    @OneToMany(mappedBy = "etudiant")
    private List<ScoreChapitre> scoreChapitreList;

    
    
    
    
    
    
    
    
    
    
    
	public String getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public Set<InscriptionCours> getInscriptionCoursList() {
		return inscriptionCoursList;
	}

	public void setInscriptionCoursList(Set<InscriptionCours> inscriptionCoursList) {
		this.inscriptionCoursList = inscriptionCoursList;
	}

	public List<ScoreChapitre> getScoreChapitreList() {
		return scoreChapitreList;
	}

	public void setScoreChapitreList(List<ScoreChapitre> scoreChapitreList) {
		this.scoreChapitreList = scoreChapitreList;
	}
	

}
