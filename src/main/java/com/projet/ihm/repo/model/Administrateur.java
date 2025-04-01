package com.projet.ihm.repo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMINISTRATEUR")
public class Administrateur extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4092141979626443583L;


}
