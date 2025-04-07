package com.projet.ihm.repo;

import org.springframework.stereotype.Repository;

import com.projet.ihm.repo.model.Specialite;


@Repository
public interface SpecialiteRepository extends AbstractRepository<Specialite, Long> {
	Specialite findByLabelle(String labelle);

}
