package com.projet.ihm.repo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "chapitre")
public class Chapitre  extends AbstractEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6322712160187380909L;

	@Column(nullable=false, unique=true)
	private String titre;
	
	@Column
	private String description;
	    
	@Column(nullable=false)
    private int maxScore; 
	
	
	@Column(nullable=false, unique=true)
    private int ordre;
	
    @OneToMany(mappedBy = "chapitre")
    private List<ScoreChapitre> scoreChapitreList;


	
    //aggregation Ressource
	@OneToMany(mappedBy = "chapitre"  ,cascade = CascadeType.PERSIST)
	private List<Ressource> ressourceList; 
	
    //aggregation Quiz
	@OneToOne(mappedBy = "chapitre") // No foreign key here
	private Quiz quiz;
	
	
	//composition Cours
	@ManyToOne
    @JoinColumn(name = "cours_id", nullable = false)
    private Cours cours;


	
	
	
	
	
	
	
	
	
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


	public int getOrdre() {
		return ordre;
	}


	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}


	public List<ScoreChapitre> getScoreChapitreList() {
		return scoreChapitreList;
	}


	public void setScoreChapitreList(List<ScoreChapitre> scoreChapitreList) {
		this.scoreChapitreList = scoreChapitreList;
	}


	public List<Ressource> getRessourceList() {
		return ressourceList;
	}


	public void setRessourceList(List<Ressource> ressourceList) {
		this.ressourceList = ressourceList;
	}


	public Quiz getQuiz() {
		return quiz;
	}


	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}


	public Cours getCours() {
		return cours;
	}


	public void setCours(Cours cours) {
		this.cours = cours;
	} 
	

}
