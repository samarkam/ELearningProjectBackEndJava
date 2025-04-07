package com.projet.ihm.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.projet.ihm.repo.model.Cours;
import com.projet.ihm.repo.model.Etudiant;
import com.projet.ihm.repo.model.InscriptionCours;



@Repository
public interface InscriptionCoursRepository extends AbstractRepository<InscriptionCours, Long> {
	InscriptionCours findByEtudiantAndCours(Etudiant etudiant, Cours cours);
	List<InscriptionCours> findByEtudiant(Etudiant etudiant);
}

