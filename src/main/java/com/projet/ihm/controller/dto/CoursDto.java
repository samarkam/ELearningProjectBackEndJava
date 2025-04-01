package com.projet.ihm.controller.dto;

import com.projet.ihm.repo.model.Cours;

public class CoursDto {

	
	public static CoursDto map(Cours cours) {
		return cours == null ? null : new CoursDto();
	}
}
