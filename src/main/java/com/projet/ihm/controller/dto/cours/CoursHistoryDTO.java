package com.projet.ihm.controller.dto.cours;

import java.util.List;

public class CoursHistoryDTO {

   private Long coursId;
    private String titre;
    private int totalScore;
    private boolean isCompleted; // Indicates if the student has completed the course

    private List<ScoreChapitreDTO> chapitreScores;

    
	public CoursHistoryDTO(Long coursId, String titre, int totalScore,boolean isCompleted, List<ScoreChapitreDTO> chapitreScores) {
		super();
		this.coursId = coursId;
		this.titre = titre;
		this.totalScore = totalScore;
        this.isCompleted = isCompleted;

		this.chapitreScores = chapitreScores;
	}

	public Long getCoursId() {
		return coursId;
	}

	public void setCoursId(Long coursId) {
		this.coursId = coursId;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public List<ScoreChapitreDTO> getChapitreScores() {
		return chapitreScores;
	}

	public void setChapitreScores(List<ScoreChapitreDTO> chapitreScores) {
		this.chapitreScores = chapitreScores;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
    
}
