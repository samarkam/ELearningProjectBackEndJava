package com.projet.ihm.controller.dto.cours;

import java.util.List;
import java.util.stream.Collectors;

import com.projet.ihm.controller.dto.EnseignantDto;
import com.projet.ihm.repo.model.Cours;
import com.projet.ihm.repo.model.InscriptionCours;

public class CoursDTO {
	
	private Long id;
    private String titre;
    private String description;
    private String image;
    private boolean isPublished;
    private boolean isActive;
    private int maxScore;
    private EnseignantDto enseignant; // Optional, depending on use case
    private SpecialiteDto specialite; // Optional
    private List<ChapitreDTO> chapitres; // For full version

    // Constructors
    public CoursDTO() {}

    public CoursDTO(Long id, String titre, String description, String image, boolean isActive, boolean isPublished) { // Light version
        this.id = id;
        this.titre = titre;
    	this.description = description;
		this.image = image;
        this.isActive = isActive;
        this.isPublished = isPublished;
    }
	
	public CoursDTO(Long id, String titre, String description, String image, boolean isActive,boolean isPublished, 
			int maxScore, EnseignantDto enseignant, SpecialiteDto specialite, List<ChapitreDTO> chapitres) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.image = image;
		this.isPublished = isPublished;
		this.isActive = isActive;
		this.maxScore = maxScore;
		this.enseignant = enseignant;
		this.specialite = specialite;
		this.chapitres = chapitres;
	}
	public static CoursDTO map(Cours cours) {
		return cours == null ? null : new CoursDTO(cours.getId(),cours.getTitre(),cours.getDescription(),cours.getImage(),cours.isActive(),cours.isPublished());
	}

	public static CoursDTO mapFullCours(Cours cours) {
		return cours == null ? null : new CoursDTO(cours.getId(),cours.getTitre(),cours.getDescription(),cours.getImage(),cours.isActive(),cours.isPublished(),
				cours.getMaxScore(),cours.getEnseignant()==null? null :  EnseignantDto.map(cours.getEnseignant())
				,cours.getSpecialite()==null ? null : SpecialiteDto.map(cours.getSpecialite())
				,cours.getChapitreList() == null ? null : cours.getChapitreList().stream().map(ChapitreDTO::mapWithResourceList).collect(Collectors.toList()));
	}
	public static CoursDTO mapFullCours( InscriptionCours inscriptionCours ) {
		Cours cours = inscriptionCours.getCours();
		return cours == null ? null : new CoursDTO(cours.getId(),cours.getTitre(),cours.getDescription(),cours.getImage(),cours.isActive(),cours.isPublished(),
				inscriptionCours.getTotalScore(),cours.getEnseignant()==null? null :  EnseignantDto.map(cours.getEnseignant())
				,cours.getSpecialite()==null ? null : SpecialiteDto.map(cours.getSpecialite())
				,cours.getChapitreList() == null ? null : cours.getChapitreList().stream().map(ChapitreDTO::mapWithResourceList).collect(Collectors.toList()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isPublished() {
		return isPublished;
	}

	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}


	public EnseignantDto getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(EnseignantDto enseignant) {
		this.enseignant = enseignant;
	}

	public SpecialiteDto getSpecialite() {
		return specialite;
	}

	public void setSpecialite(SpecialiteDto specialite) {
		this.specialite = specialite;
	}

	public List<ChapitreDTO> getChapitres() {
		return chapitres;
	}

	public void setChapitres(List<ChapitreDTO> chapitres) {
		this.chapitres = chapitres;
	}
	
	
	
}
