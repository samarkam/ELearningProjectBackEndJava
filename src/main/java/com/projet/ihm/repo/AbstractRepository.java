package com.projet.ihm.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.io.Serializable;

@NoRepositoryBean
public interface AbstractRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}