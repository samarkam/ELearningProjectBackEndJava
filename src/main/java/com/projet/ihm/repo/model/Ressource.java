package com.projet.ihm.repo.model;

import org.apache.commons.lang3.StringUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "ressource")
public class Ressource  extends AbstractEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 681706136608017139L;

	@Column(nullable=false, unique=false)
	private String titre;
	
	@Column(nullable=false)
	private String description;
	
	@Column(nullable=false, unique=true)
	private String url;
	
	
	// byte 
	
	@Column(name="type_ressource" , nullable=false)
	private TypeRessource typeRessource;
	
	
    //aggregation Ressource
    @ManyToOne
    @JoinColumn(name = "chapitre_id", nullable = false)
    private Chapitre chapitre;
    
    
    public enum TypeRessource{
    	
    	PDF,IMAGE,VIDEO;
    	
    	public static TypeRessource getType(String inputType) {
    		if(StringUtils.isBlank(inputType)) {
    	        return null;

    		}
    		switch (inputType.toUpperCase()) {
	    	    case "PDF": return PDF ;
	    	    case "IMAGE": return IMAGE;
	    	    case "VIDEO": return VIDEO;
	    	    default:
	    	        return null;
	    	}
    	}
    	
    	
    }

    
    
    
    
    
    
    
    
    
    
    
    
    

	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public TypeRessource getTypeRessource() {
		return typeRessource;
	}


	public void setTypeRessource(TypeRessource typeRessource) {
		this.typeRessource = typeRessource;
	}


	public Chapitre getChapitre() {
		return chapitre;
	}


	public void setChapitre(Chapitre chapitre) {
		this.chapitre = chapitre;
	}
    
    
    
    
}
