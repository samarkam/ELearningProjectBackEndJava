package com.projet.ihm.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.projet.ihm.repo.model.Question;
import com.projet.ihm.repo.model.Quiz;


@Repository
public interface QuestionRepository extends AbstractRepository<Question, Long> {
	List<Question> findByQuiz(Quiz quiz );
}
