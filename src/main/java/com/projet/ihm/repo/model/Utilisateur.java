package com.projet.ihm.repo.model;


import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
public class Utilisateur extends AbstractEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8665655590273460948L;

	@Column(nullable = false)
    private String nom;

	@Column(nullable = false)
    private String prenom; 

	@Column(nullable = false)
    private String telephone; 

	@Column(name="date_de_naissance",nullable = false)
    private Date dateDeNaissance; 
	 
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;
    
	@Column
    private String details;

    
    @Column(nullable = false)
    private boolean isBlocked; // default 0
    
    public enum userRole{
    	ADMINISTRATEUR,ETUDIANT,ENSEIGNANT 
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

	
}
