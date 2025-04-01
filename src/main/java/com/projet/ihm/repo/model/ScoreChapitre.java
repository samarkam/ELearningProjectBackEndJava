package com.projet.ihm.repo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

	
@Entity
@Table(name = "scrore-chapitre")
public class ScoreChapitre  extends AbstractEntity{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1475792827762743292L;

	@Column(nullable=false)
    private int score;
	
	@Column(nullable=false)
	private Date date;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "chapitre_id")
    private Chapitre chapitre;

    
    
    
    
    
    
    
    
    
    
    
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Chapitre getChapitre() {
		return chapitre;
	}

	public void setChapitre(Chapitre chapitre) {
		this.chapitre = chapitre;
	}
    
}


