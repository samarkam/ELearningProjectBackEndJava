package com.projet.ihm.repo;

import org.springframework.stereotype.Repository;

import com.projet.ihm.repo.model.Ressource;


@Repository
public interface ResourceRepository extends AbstractRepository<Ressource, Long> {
	Ressource findByUrl(String url);
}
