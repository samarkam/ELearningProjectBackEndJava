package com.projet.ihm.repo;

import org.springframework.stereotype.Repository;

import com.projet.ihm.repo.model.Chapitre;
import com.projet.ihm.repo.model.Quiz;


@Repository
public interface QuizRepository extends AbstractRepository<Quiz, Long> {
	Quiz findByTitre(String titre);
	Quiz findByChapitre(Chapitre chapitre);
}
