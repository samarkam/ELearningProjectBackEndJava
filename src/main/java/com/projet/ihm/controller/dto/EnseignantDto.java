package com.projet.ihm.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.projet.ihm.controller.dto.cours.CoursDTO;
import com.projet.ihm.repo.model.Enseignant;


public class EnseignantDto {

    private Long id;
    
    private String nom;

    private String prenom; 

    private String telephone; 

    private Date dateDeNaissance; 
	 
    private String password;

    private String email;
    
    private String details;
    
	private String matricule;
	
	private String specialite;

    private List<CoursDTO> coursList;
    
    private boolean isBlocked;

	public EnseignantDto(Long id, String nom, String prenom, String telephone, Date dateDeNaissance, String password,
			String email, String details, boolean isBlocked,String matricule, String specialite,List<CoursDTO> coursList) {
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
		this.matricule = matricule;
		this.specialite = specialite;
		this.coursList = coursList;
	}

	public static EnseignantDto map(Enseignant utilisateur) {
		return utilisateur == null ? null : new EnseignantDto(utilisateur.getId(),  utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getTelephone(), 
				utilisateur.getDateDeNaissance(), utilisateur.getPassword(), utilisateur.getEmail(), utilisateur.getDetails(), utilisateur.isBlocked(),
				utilisateur.getMatricule(),utilisateur.getSpecialite(),
				null);
	}
	public static EnseignantDto mapWithCours(Enseignant utilisateur) {
		return utilisateur == null ? null : new EnseignantDto(utilisateur.getId(),  utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getTelephone(), 
				utilisateur.getDateDeNaissance(), utilisateur.getPassword(), utilisateur.getEmail(), utilisateur.getDetails(), utilisateur.isBlocked(),
				utilisateur.getMatricule(),utilisateur.getSpecialite(),
				utilisateur.getCoursList() == null ?null:utilisateur.getCoursList().stream().map(CoursDTO::map).collect(Collectors.toList()));
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


	public List<CoursDTO> getCoursList() {
		return coursList;
	}


	public void setCoursList(List<CoursDTO> coursList) {
		this.coursList = coursList;
	}


	
    
    
    
}
