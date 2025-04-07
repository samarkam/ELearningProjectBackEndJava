package com.projet.ihm.repo;

import org.springframework.stereotype.Repository;

import com.projet.ihm.repo.model.Dicipline;


@Repository
public interface DiciplineRepository extends AbstractRepository<Dicipline, Long> {
	Dicipline findByTitre(String titre);

}
