package com.projet.ihm.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.projet.ihm.repo.model.Etudiant;


public class EtudiantDto {

    private Long id;
    
    private String nom;

    private String prenom; 

    private String telephone; 

    private Date dateDeNaissance; 
	 
    private String password;

    private String email;
    
    private String details;
    
    private List<InscriptionCoursDto> inscriptionCoursList;

    private String niveauEtude;
    
    private List<ScoreChapitreDto> scoreChapitreList;
    private boolean isBlocked;

	public EtudiantDto(Long id, String nom, String prenom, String telephone, Date dateDeNaissance, String password,
			String email, String details, boolean isBlocked,String niveauEtude,List<InscriptionCoursDto> inscriptionCoursList,List<ScoreChapitreDto> scoreChapitreList) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.dateDeNaissance = dateDeNaissance;
		this.password = password;
		this.email = email;
		this.details = details;
		this.isBlocked = isBlocked;
		this.niveauEtude = niveauEtude;
		this.inscriptionCoursList = inscriptionCoursList;
		this.scoreChapitreList = scoreChapitreList;
	}

	
	public static EtudiantDto map(Etudiant utilisateur) {
		return utilisateur == null ? null : new EtudiantDto(utilisateur.getId(),  utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getTelephone(), 
				utilisateur.getDateDeNaissance(), utilisateur.getPassword(), utilisateur.getEmail(), utilisateur.getDetails(), utilisateur.isBlocked(),
				utilisateur.getNiveauEtude(),
				utilisateur.getInscriptionCoursList() == null ? null : utilisateur.getInscriptionCoursList().stream().map(InscriptionCoursDto::map).collect(Collectors.toList()),
				utilisateur.getScoreChapitreList()	==null ? null : 	utilisateur.getScoreChapitreList().stream().map(ScoreChapitreDto::map).collect(Collectors.toList()));
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}


	public List<InscriptionCoursDto> getInscriptionCoursList() {
		return inscriptionCoursList;
	}


	public void setInscriptionCoursList(List<InscriptionCoursDto> inscriptionCoursList) {
		this.inscriptionCoursList = inscriptionCoursList;
	}


	public String getNiveauEtude() {
		return niveauEtude;
	}


	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}


	public List<ScoreChapitreDto> getScoreChapitreList() {
		return scoreChapitreList;
	}


	public void setScoreChapitreList(List<ScoreChapitreDto> scoreChapitreList) {
		this.scoreChapitreList = scoreChapitreList;
	} 
    
    
    
    
}
