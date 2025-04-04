package com.projet.ihm.controller.dto.cours;


import java.util.Date;

import com.projet.ihm.repo.model.ScoreChapitre;

public class ScoreChapitreDTO {

	
	 private Long id;
    private int score;
    private Date date;
  

   
	
	
	public ScoreChapitreDTO(Long id, int score, Date date2) {
		super();
		this.id = id;
		this.score = score;
		this.date = date2;
	}


	public static ScoreChapitreDTO map(ScoreChapitre scoreChapitre) {
		return scoreChapitre == null ? null : new ScoreChapitreDTO(scoreChapitre.getId(),scoreChapitre.getScore(),scoreChapitre.getDate());
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


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


}
