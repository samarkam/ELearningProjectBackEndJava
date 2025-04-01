package com.projet.ihm.controller.dto;

import com.projet.ihm.repo.model.InscriptionCours;

public class InscriptionCoursDto {

	
	public static InscriptionCoursDto map(InscriptionCours inscriptionCours) {
		return inscriptionCours == null ? null : new InscriptionCoursDto();
	}
	
}
