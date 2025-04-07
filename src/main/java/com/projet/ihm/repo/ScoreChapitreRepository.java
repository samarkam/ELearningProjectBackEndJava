package com.projet.ihm.repo;


import org.springframework.stereotype.Repository;

import com.projet.ihm.repo.model.Chapitre;
import com.projet.ihm.repo.model.Etudiant;
import com.projet.ihm.repo.model.ScoreChapitre;


@Repository
public interface ScoreChapitreRepository extends AbstractRepository<ScoreChapitre, Long> {
	ScoreChapitre findByEtudiantAndChapitre(Etudiant etudiant, Chapitre chapitre);

}
