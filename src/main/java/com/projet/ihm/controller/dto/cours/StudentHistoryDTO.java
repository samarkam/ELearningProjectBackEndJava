package com.projet.ihm.controller.dto.cours;

import java.util.List;

public class StudentHistoryDTO {

	
	private Long etudiantId;
    private List<CoursHistoryDTO> coursHistory;

	public StudentHistoryDTO(Long etudiantId, List<CoursHistoryDTO> coursHistory) {
		super();
		this.etudiantId = etudiantId;
		this.coursHistory = coursHistory;
	}

	public Long getEtudiantId() {
		return etudiantId;
	}

	public void setEtudiantId(Long etudiantId) {
		this.etudiantId = etudiantId;
	}

	public List<CoursHistoryDTO> getCoursHistory() {
		return coursHistory;
	}

	public void setCoursHistory(List<CoursHistoryDTO> coursHistory) {
		this.coursHistory = coursHistory;
	}
    
    
}
