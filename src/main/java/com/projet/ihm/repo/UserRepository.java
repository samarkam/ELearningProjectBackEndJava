package com.projet.ihm.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.ihm.repo.model.Utilisateur;

@Repository
public interface UserRepository extends AbstractRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);
    
    @Query("SELECT u.isBlocked FROM Utilisateur u WHERE u.id = :id")
    Boolean getIsBlocked(@Param("id") Long id);
}