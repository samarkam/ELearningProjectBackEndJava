package com.projet.ihm.controller.dto.cours;

import com.projet.ihm.controller.dto.EtudiantDto;
import com.projet.ihm.repo.model.InscriptionCours;

public class InscriptionCoursDto {

    private Long id;
    private int totalScore; 
    
    private EtudiantDto etudiant;

    private CoursDTO cours;
	   
    
	public InscriptionCoursDto(Long id, int totalScore, EtudiantDto etudiant, CoursDTO cours) {
		super();
		this.id = id;
		this.totalScore = totalScore;
		this.etudiant = etudiant;
		this.cours = cours;
	}


	public static InscriptionCoursDto map(InscriptionCours inscriptionCours) {
		return inscriptionCours == null ? null : new InscriptionCoursDto(inscriptionCours.getId(),inscriptionCours.getTotalScore(),
				inscriptionCours.getEtudiant() == null ? null : EtudiantDto.map(inscriptionCours.getEtudiant())
				,inscriptionCours.getCours()==null ? null : CoursDTO.map(inscriptionCours.getCours()));
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getTotalScore() {
		return totalScore;
	}


	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}


	public EtudiantDto getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(EtudiantDto etudiant) {
		this.etudiant = etudiant;
	}


	public CoursDTO getCours() {
		return cours;
	}


	public void setCours(CoursDTO cours) {
		this.cours = cours;
	}
	
}
