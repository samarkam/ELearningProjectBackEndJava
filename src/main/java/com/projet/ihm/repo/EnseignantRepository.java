package com.projet.ihm.repo;

import org.springframework.stereotype.Repository;

import com.projet.ihm.repo.model.Enseignant;

@Repository
public interface EnseignantRepository extends AbstractRepository<Enseignant, Long> {
	Enseignant findByEmail(String email);
}
