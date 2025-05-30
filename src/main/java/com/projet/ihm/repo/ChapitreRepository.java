package com.projet.ihm.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.projet.ihm.repo.model.Chapitre;
import com.projet.ihm.repo.model.Cours;

@Repository
public interface ChapitreRepository extends AbstractRepository<Chapitre, Long> {
	Chapitre findByOrdreAndCours(int ordre,Cours cours );
	List<Chapitre> findByCours (Cours cours );
}