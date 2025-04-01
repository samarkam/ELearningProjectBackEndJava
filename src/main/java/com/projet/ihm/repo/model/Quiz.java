package com.projet.ihm.repo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "quiz")
public class Quiz  extends AbstractEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2768887499651439084L;



	@Column(nullable=false, unique=true)
	private String titre;
	

	
    //aggregation Quiz
	@OneToOne
    @JoinColumn(name = "chapitre_id", unique = true) // Foreign key in Quiz table
    private Chapitre chapitre;
    
    
  
    
	//composition question
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Question> questionList;


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public Chapitre getChapitre() {
		return chapitre;
	}



	public void setChapitre(Chapitre chapitre) {
		this.chapitre = chapitre;
	}



	public List<Question> getQuestionList() {
		return questionList;
	}



	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
    
	
	
	
	
    
    
}
