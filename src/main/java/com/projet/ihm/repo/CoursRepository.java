package com.projet.ihm.repo;

import org.springframework.stereotype.Repository;

import com.projet.ihm.repo.model.Cours;

@Repository
public interface CoursRepository extends AbstractRepository<Cours, Long> {
	Cours findByTitre(String titre);

}