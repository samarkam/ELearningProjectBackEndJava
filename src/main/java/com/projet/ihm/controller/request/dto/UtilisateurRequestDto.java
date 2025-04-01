package com.projet.ihm.controller.request.dto;

import java.util.Date;


public class UtilisateurRequestDto {

    
    private String nom;

    private String prenom; 

    private String telephone; 

    private Date dateDeNaissance; 
	 
    private String password;

    private String email;
    
    private String details;
    
    private String matricule;
	
	private String specialite;

	  private String niveauEtude;
	  
	


	public UtilisateurRequestDto(String nom, String prenom, String telephone, Date dateDeNaissance, String password,
			String email, String details, String matricule, String specialite, String niveauEtude) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.dateDeNaissance = dateDeNaissance;
		this.password = password;
		this.email = email;
		this.details = details;
		this.matricule = matricule;
		this.specialite = specialite;
		this.niveauEtude = niveauEtude;
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

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}


}
