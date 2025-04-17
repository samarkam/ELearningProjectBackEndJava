package com.projet.ihm.controller.dto;

import java.util.Date;

import com.projet.ihm.repo.model.Etudiant;


public class EtudiantRequestDto {

    private Long id;
    
    private String nom;

    private String prenom; 

    private String telephone; 

    private Date dateDeNaissance; 
	 
    private String password;

    private String email;
    
    private String image;
    
    private String details;

    private String niveauEtude;

  

	public EtudiantRequestDto(Long id, String nom, String prenom, String telephone, Date dateDeNaissance, String password,
			String email,String image, String details,String niveauEtude) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.dateDeNaissance = dateDeNaissance;
		this.password = password;
		this.email = email;
		this.image = image;
		this.details = details;
		this.niveauEtude = niveauEtude;

	}

	
	public static EtudiantRequestDto map(Etudiant utilisateur) {
		return utilisateur == null ? null : new EtudiantRequestDto(utilisateur.getId(),  utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getTelephone(), 
				utilisateur.getDateDeNaissance(), utilisateur.getPassword(), utilisateur.getEmail(),utilisateur.getImage(), utilisateur.getDetails(), 
				utilisateur.getNiveauEtude());
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



	public String getNiveauEtude() {
		return niveauEtude;
	}


	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


    
}
