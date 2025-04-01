package com.projet.ihm.controller.dto;

import com.projet.ihm.repo.model.ScoreChapitre;

public class ScoreChapitreDto {

	
	
	
	
	public static ScoreChapitreDto map(ScoreChapitre scoreChapitre) {
		return scoreChapitre == null ? null : new ScoreChapitreDto();
	}
}
