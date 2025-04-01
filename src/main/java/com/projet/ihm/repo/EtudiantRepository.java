package com.projet.ihm.repo;

import org.springframework.stereotype.Repository;

import com.projet.ihm.repo.model.Etudiant;

@Repository
public interface EtudiantRepository extends AbstractRepository<Etudiant, Long> {
	Etudiant findByEmail(String email);
}
