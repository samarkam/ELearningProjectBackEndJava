package com.projet.ihm.repo;

import org.springframework.stereotype.Repository;

import com.projet.ihm.repo.model.Administrateur;

@Repository
public interface AdministrateurRepository extends AbstractRepository<Administrateur, Long> {
	Administrateur findByEmail(String email);
}
