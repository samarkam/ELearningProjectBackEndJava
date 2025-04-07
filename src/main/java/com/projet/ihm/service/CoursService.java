package com.projet.ihm.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ihm.controller.dto.cours.ChapitreDTO;
import com.projet.ihm.controller.dto.cours.CoursDTO;
import com.projet.ihm.controller.dto.cours.CoursHistoryDTO;
import com.projet.ihm.controller.dto.cours.InscriptionCoursDto;
import com.projet.ihm.controller.dto.cours.QuizDTO;
import com.projet.ihm.controller.dto.cours.QuizSubmissionDTO;
import com.projet.ihm.controller.dto.cours.ResourceDTO;
import com.projet.ihm.controller.dto.cours.ScoreChapitreDTO;
import com.projet.ihm.controller.dto.cours.StudentHistoryDTO;
import com.projet.ihm.controller.request.dto.ChapitreRequestDTO;
import com.projet.ihm.controller.request.dto.CoursRequestDTO;
import com.projet.ihm.controller.request.dto.QuestionRequestDTO;
import com.projet.ihm.controller.request.dto.QuizRequestDTO;
import com.projet.ihm.controller.request.dto.ResourceRequestDTO;
import com.projet.ihm.repo.ChapitreRepository;
import com.projet.ihm.repo.CoursRepository;
import com.projet.ihm.repo.EnseignantRepository;
import com.projet.ihm.repo.InscriptionCoursRepository;
import com.projet.ihm.repo.QuestionRepository;
import com.projet.ihm.repo.QuizRepository;
import com.projet.ihm.repo.ResourceRepository;
import com.projet.ihm.repo.ScoreChapitreRepository;
import com.projet.ihm.repo.model.Chapitre;
import com.projet.ihm.repo.model.Cours;
import com.projet.ihm.repo.model.Enseignant;
import com.projet.ihm.repo.model.Etudiant;
import com.projet.ihm.repo.model.InscriptionCours;
import com.projet.ihm.repo.model.Question;
import com.projet.ihm.repo.model.Quiz;
import com.projet.ihm.repo.model.Ressource;
import com.projet.ihm.repo.model.ScoreChapitre;
import com.projet.ihm.repo.model.Specialite;
import com.projet.ihm.repo.model.Utilisateur;

import jakarta.transaction.Transactional;

@Service
public class CoursService {

   public static final int COURS_MAX_SCORE = 100;

   @Autowired
   private SpecialiteDiciplineService specialiteService;
   @Autowired
    private CoursRepository coursRepository;

    
    @Autowired
    private UserService userService;
    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private EnseignantRepository enseignantRepository;    
        
    @Autowired
    private ChapitreRepository chapitreRepository;
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizRepository quizRepository;
    
    @Autowired
    private InscriptionCoursRepository inscriptionCoursRepository;
    @Autowired
    private ScoreChapitreRepository scoreChapitreRepository;
    
   
   
    

    public List<CoursDTO> getAllCoursesLight() {
        return coursRepository.findAll().stream()
                .map(CoursDTO::map)
                .collect(Collectors.toList());
    }

    public List<CoursDTO> getAllCourses() {
        return coursRepository.findAll().stream()
                .map(CoursDTO::mapFullCours)
                .collect(Collectors.toList());
    }

    public List<CoursDTO> getMyCourses(String email) {

        Utilisateur user = userService.getUserByEmail(email);
        Utilisateur.userRole userRole =  userService.getUserRoleByEmail(email);
        if(user==null || userRole==null) {
            throw new RuntimeException("Invalid user role");

        }
        if (Utilisateur.userRole.ENSEIGNANT.equals(userRole)) {
            return ((Enseignant) user).getCoursList().stream()
                    .map(CoursDTO::mapFullCours)
                    .collect(Collectors.toList());
        } else  if (Utilisateur.userRole.ETUDIANT.equals(userRole)) {
        	List<InscriptionCours> list=  ((Etudiant) user).getInscriptionCoursList();
             if(list==null || list.isEmpty()) {
            	 return Collections.emptyList();
             }
             
             return list.stream()
                     .map(InscriptionCours::getCours)
                     .map(CoursDTO::mapFullCours) 
                     .collect(Collectors.toList());
             
        }
        throw new RuntimeException("Invalid user role");
    }

    @Transactional
    public CoursDTO createCourse(CoursRequestDTO coursDTO) {
    	if(coursDTO==null) {
            throw new RuntimeException("Invalid coursDTO");

    	}
        Enseignant user = enseignantRepository.findByEmail(coursDTO.getEnseignantEmail());
        if(user==null) {
            throw new RuntimeException("Invalid user");

        }
        Utilisateur.userRole userRole =  userService.getUserRoleByEmail(user.getEmail());
        if(userRole==null || !Utilisateur.userRole.ENSEIGNANT.equals(userRole)) {
            throw new RuntimeException("Invalid user role");

        }
        Specialite specialite = specialiteService.getSpecialiteById(coursDTO.getSpecialiteId());
        if(specialite==null) {
            throw new RuntimeException("Invalid specialite");

        }
        Cours cours = new Cours();
        cours.setTitre(coursDTO.getTitre());
        cours.setDescription(coursDTO.getDescription());
        cours.setEnseignant(user);
        cours.setImage(coursDTO.getImage());
        cours.setMaxScore(COURS_MAX_SCORE);
        cours.setSpecialite(specialite);
        return CoursDTO.map(coursRepository.save(cours));
    }
    
    
    @Transactional
    public CoursDTO updateCourse( Long id, CoursRequestDTO coursDTO) {
    	if(coursDTO==null || id == null) {
            throw new RuntimeException("Invalid coursDTO");

    	}
    	
    	Cours cours = getCoursById(id);
    	if(cours == null) {
            throw new RuntimeException("Invalid cours id");

    	}
        Enseignant user = enseignantRepository.findByEmail(coursDTO.getEnseignantEmail());
        if(user==null) {
            throw new RuntimeException("Invalid user");

        }
        Utilisateur.userRole userRole =  userService.getUserRoleByEmail(user.getEmail());
        if(userRole==null || !Utilisateur.userRole.ENSEIGNANT.equals(userRole)) {
            throw new RuntimeException("Invalid user role");

        }
        Specialite specialite = specialiteService.getSpecialiteById(coursDTO.getSpecialiteId());
        if(specialite==null) {
            throw new RuntimeException("Invalid specialite");

        }
        cours.setTitre(coursDTO.getTitre());
        cours.setDescription(coursDTO.getDescription());
        cours.setEnseignant(user);
        cours.setImage(coursDTO.getImage());
        cours.setMaxScore(COURS_MAX_SCORE);
        cours.setSpecialite(specialite);
        return CoursDTO.map(coursRepository.save(cours));
    }

    
    @Transactional
    public ChapitreDTO createChapitre( ChapitreRequestDTO chapitreDTO) {
    	if(chapitreDTO == null) {
        	throw new RuntimeException("chapitreDTO not found");
    	}
        Cours cours = getCoursById(chapitreDTO.getCoursId());
        if(cours==null) {
        	throw new RuntimeException("Course not found");
        }
        if(getChapitreByOrder(chapitreDTO.getOrdre()) != null ) {
			throw new RuntimeException("Chapitre ordre already exists");

    	}
        Chapitre chapitre = new Chapitre();
        chapitre.setTitre(chapitreDTO.getTitre());
        chapitre.setOrdre(chapitreDTO.getOrdre());
        chapitre.setDescription(chapitreDTO.getDescription());
        chapitre.setMaxScore(chapitreDTO.getMaxScore());
        chapitre.setCours(cours);
        return ChapitreDTO.map(chapitreRepository.save(chapitre));
    }
    
    
    
    @Transactional
    public ChapitreDTO updateChapitre(Long id, ChapitreRequestDTO chapitreDTO) {
    	if(chapitreDTO == null|| id ==null) {
        	throw new RuntimeException("chapitreDTO ou id not found");
    	}
    	Chapitre chapitre = getChapitreById(id);
    	if(chapitre == null) {
        	throw new RuntimeException("chapitre not found");
    	}
        Cours cours = getCoursById(chapitreDTO.getCoursId());
        if(cours==null) {
        	throw new RuntimeException("Course not found");
        }
        if(getChapitreByOrder(chapitreDTO.getOrdre()) != null ) {
			throw new RuntimeException("Chapitre ordre already exists");

    	}
        chapitre.setTitre(chapitreDTO.getTitre());
        chapitre.setOrdre(chapitreDTO.getOrdre());
        chapitre.setDescription(chapitreDTO.getDescription());
        chapitre.setMaxScore(chapitreDTO.getMaxScore());
        chapitre.setCours(cours);
        return ChapitreDTO.map(chapitreRepository.save(chapitre));
    }
    
    
    @Transactional
    public ResourceDTO createRessource( ResourceRequestDTO resourceDTO) {
    	if(resourceDTO == null) {
        	throw new RuntimeException("resourceDTO not found");
    	}
        Chapitre chapitre = getChapitreById(resourceDTO.getChapitreId());
        if(chapitre==null) {
        	throw new RuntimeException("chapitre not found");
        }
        if(StringUtils.isBlank(resourceDTO.getTypeRessource())) {
        	throw new RuntimeException("type de Ressource not found");
        }else  if(Ressource.TypeRessource.getType(resourceDTO.getTypeRessource().toUpperCase()) == null ) {
        	throw new RuntimeException("type de Ressource not found");
        }
        
        Ressource userWithUrl = resourceRepository.findByUrl(resourceDTO.getUrl());
	    if (userWithUrl != null ) {
	        throw new RuntimeException("Ressource Url already exists");
	    }
        Ressource resource = new Ressource();
        resource.setTitre(resourceDTO.getTitre());
        resource.setUrl(resourceDTO.getUrl());
        resource.setDescription(resourceDTO.getDescription());
        resource.setTypeRessource(Ressource.TypeRessource.getType(resourceDTO.getTypeRessource().toUpperCase()));
        resource.setChapitre(chapitre);
        return ResourceDTO.map(resourceRepository.save(resource));
    }
    
    
    
    @Transactional
    public ResourceDTO updateRessource(Long id , ResourceRequestDTO resourceDTO) {
    	if(resourceDTO == null || id ==null) {
        	throw new RuntimeException("resourceDTO ou id not found");
    	}
    	 Ressource resource = getRessourceById(id);
        if(resource==null) {
        	throw new RuntimeException("ressource not found");
        }
        Chapitre chapitre = getChapitreById(id);
        if(chapitre==null) {
        	throw new RuntimeException("chapitre not found");
        }
        if(StringUtils.isBlank(resourceDTO.getTypeRessource())) {
        	throw new RuntimeException("type de Ressource not found");
        }else  if(Ressource.TypeRessource.getType(resourceDTO.getTypeRessource().toUpperCase()) == null ) {
        	throw new RuntimeException("type de Ressource not found");
        }
        
        Ressource userWithUrl = resourceRepository.findByUrl(resourceDTO.getUrl());
	    if (userWithUrl != null ) {
	        throw new RuntimeException("Ressource Url already exists");
	    }
        resource.setTitre(resourceDTO.getTitre());
        resource.setUrl(resourceDTO.getUrl());
        resource.setDescription(resourceDTO.getDescription());
        resource.setTypeRessource(Ressource.TypeRessource.getType(resourceDTO.getTypeRessource().toUpperCase()));
        resource.setChapitre(chapitre);
        return ResourceDTO.map(resourceRepository.save(resource));
    }
    @Transactional
    public QuizDTO createQuiz( QuizRequestDTO quizDto) {
    	if(quizDto == null) {
        	throw new RuntimeException("quizDto not found");
    	}
    	if(quizDto.getQuestions() == null || quizDto.getQuestions() .isEmpty()) {
        	throw new RuntimeException("Questions du quizDto not found");
    	}
        Chapitre chapitre = getChapitreById(quizDto.getChapitreId());
        if(chapitre==null) {
        	throw new RuntimeException("chapitre not found");
        }
        if(StringUtils.isBlank(quizDto.getTitre())) {
        	throw new RuntimeException("Titre de Quiz not found");
        }
        
        Quiz Quiz = quizRepository.findByTitre(quizDto.getTitre());
	    if (Quiz != null ) {
	        throw new RuntimeException("Titre de Quiz already exists");
	    }
	    List<Question> questions = new ArrayList<Question>();
	    for (QuestionRequestDTO questionDto : quizDto.getQuestions()) {
			if(questionDto == null) {
				throw new RuntimeException("Question not found");
			}
			if(StringUtils.isBlank(questionDto.getEnoncce()) || StringUtils.isBlank(questionDto.getReponseCorrecte()) || questionDto.getReponseIncorrecteList().isEmpty()) {
				throw new RuntimeException("Question not valid");
			}
			
		}
	    Quiz quiz = new Quiz();
        quiz.setTitre(quizDto.getTitre());
        quiz.setChapitre(chapitre);
        quiz =  quizRepository.save(quiz);
        for (QuestionRequestDTO questionDto : quizDto.getQuestions()) {
			
			Question question= new Question();
			question.setEnoncce(questionDto.getEnoncce());
			question.setReponseCorrecte(questionDto.getReponseCorrecte());
			question.setReponseIncorrecteList(questionDto.getReponseIncorrecteList());
			question.setQuiz(quiz);
			question = questionRepository.save(question);
			questions.add(question);
		}
        quiz.setQuestionList(questions);
        quiz =  quizRepository.save(quiz);
        return QuizDTO.mapWithQuestions(quiz);
    }
    
    @Transactional
    public QuizDTO updateQuiz(Long id, QuizRequestDTO quizDto) {
    	if(quizDto == null || id==null) {
        	throw new RuntimeException("quizDto not found");
    	}
    	if(quizDto.getQuestions() == null || quizDto.getQuestions() .isEmpty()) {
        	throw new RuntimeException("Questions du quizDto not found");
    	}
    	Quiz quiz= getQuizById( id);
    	if(quiz == null ) {
        	throw new RuntimeException("quiz not found");
    	}
        Chapitre chapitre = getChapitreById(quizDto.getChapitreId());
        if(chapitre==null) {
        	throw new RuntimeException("chapitre not found");
        }
        if(StringUtils.isBlank(quizDto.getTitre())) {
        	throw new RuntimeException("Titre de Quiz not found");
        }
        
        Quiz Quiz = quizRepository.findByTitre(quizDto.getTitre());
	    if (Quiz != null ) {
	        throw new RuntimeException("Titre de Quiz already exists");
	    }
	    List<Question> questions = new ArrayList<Question>();
	    for (QuestionRequestDTO questionDto : quizDto.getQuestions()) {
			if(questionDto == null) {
				throw new RuntimeException("Question not found");
			}
			if(StringUtils.isBlank(questionDto.getEnoncce()) || StringUtils.isBlank(questionDto.getReponseCorrecte()) || questionDto.getReponseIncorrecteList().isEmpty()) {
				throw new RuntimeException("Question not valid");
			}
			
		}
        quiz.setTitre(quizDto.getTitre());
        quiz.setChapitre(chapitre);
        quiz =  quizRepository.save(quiz);
        for (QuestionRequestDTO questionDto : quizDto.getQuestions()) {
			
			Question question= new Question();
			question.setEnoncce(questionDto.getEnoncce());
			question.setReponseCorrecte(questionDto.getReponseCorrecte());
			question.setReponseIncorrecteList(questionDto.getReponseIncorrecteList());
			question.setQuiz(quiz);
			question = questionRepository.save(question);
			questions.add(question);
		}
        quiz.setQuestionList(questions);
        quiz =  quizRepository.save(quiz);
        return QuizDTO.mapWithQuestions(quiz);
    }

    public Chapitre getChapitreByOrder(int ordre) {
        return chapitreRepository.findByOrdre(ordre)  ;
    } 
    public Cours getCoursById(Long id) {
    	Optional<Cours> optional = coursRepository.findById(id) ;
        return optional.isPresent() ? optional.get(): null;
    }

   
    public Chapitre getChapitreById(Long id) {
    	Optional<Chapitre> optional = chapitreRepository.findById(id) ;
        return optional.isPresent() ? optional.get(): null;
    }
 
    public  Ressource getRessourceById(Long id) {
    	Optional<Ressource> optional = resourceRepository.findById(id) ;
        return optional.isPresent() ? optional.get(): null;
    }
 
    public Quiz getQuizById(Long id) {
    	Optional<Quiz> optional = quizRepository.findById(id) ;
        return optional.isPresent() ? optional.get(): null;
    }
    public boolean updateIsActive(Long id, Boolean isActive) {
    	if(isActive == null ) {
            return false;
    	}
    	Cours cours = getCoursById(id);
        if (cours != null) {
        	cours.setActive(isActive);
        	coursRepository.save(cours);
            return true;
        }
        return false;
    }
    
    public boolean updateIsPublished(Long id, Boolean isPublished) {
    	if(isPublished == null ) {
            return false;
    	}
    	Cours cours = getCoursById(id);
        if (cours != null) {
        	cours.setPublished(isPublished);
        	coursRepository.save(cours);
            return true;
        }
        return false;
    }
    
    
    public InscriptionCoursDto inscriptionCours(Long etudiantId, Long coursId) {
    	 Etudiant etudiant = etudiantService.getUserById(etudiantId);
    	 if(etudiant==null) {
           	throw new RuntimeException("Etudiant not found");
           }
    	  Cours cours = getCoursById(coursId);
          if(cours==null) {
          	throw new RuntimeException("Course not found");
          }
    	InscriptionCours inscriptionCours = new InscriptionCours();
    	inscriptionCours.setCours(cours);
    	inscriptionCours.setEtudiant(etudiant);
    	inscriptionCours.setTotalScore(0);
    	
    	return InscriptionCoursDto.map(inscriptionCoursRepository.save(inscriptionCours));
    }
    
    @Transactional
    public ScoreChapitreDTO submitQuiz( QuizSubmissionDTO submission) {
        // 1. Validate the student
        Etudiant etudiant =  etudiantService.getUserById(submission.getEtudiantId());
        if(etudiant == null) { 
        	throw new RuntimeException("Student not found with ID: " + submission.getEtudiantId());
        }
        
        
        // 2. Validate the quiz 
        Quiz quiz= getQuizById( submission.getQuizId());
    	if(quiz == null ) {
        	throw new RuntimeException("quiz not found");
    	}

        // 3. Fetch quiz questions
        List<Question> questions = questionRepository.findByQuiz(quiz);
        if (questions.isEmpty()) {
            throw new RuntimeException("No questions found for quiz ID: " + submission.getQuizId());
        }

        // 4. Calculate score
        int totalQuestions = questions.size();
        int correctAnswers = 0;
        
        Map<Long, String> studentAnswers = submission.getAnswers();
        for (Question question : questions) {
            String studentAnswer = studentAnswers.get(question.getId());
            if (studentAnswer != null && studentAnswer.equals(question.getReponseCorrecte())) {
                correctAnswers++;
            }
        }

        // Calculate score as a percentage of maxScore for the chapter
        int maxScore = quiz.getChapitre().getMaxScore();
        int score = (int) ((correctAnswers / (double) totalQuestions) * maxScore);

        // 5. Create and save ScoreChapitre
        ScoreChapitre scoreChapitre = new ScoreChapitre();
        scoreChapitre.setEtudiant(etudiant);
        scoreChapitre.setChapitre(quiz.getChapitre());
        scoreChapitre.setScore(score);
        scoreChapitre.setDate(new Date()); // Current date
        
        scoreChapitre = scoreChapitreRepository.save(scoreChapitre);

        // 6. Update total score in InscriptionCours (optional)
        InscriptionCours inscription = inscriptionCoursRepository.findByEtudiantAndCours(etudiant, quiz.getChapitre().getCours());
        if(inscription==null) {
        	throw new RuntimeException("Student not enrolled in course");
        }
        inscription.setTotalScore(inscription.getTotalScore()+score);
        inscriptionCoursRepository.save(inscription);

        // 7. Return ScoreChapitreDTO
        return ScoreChapitreDTO.map(scoreChapitre);
    }
    
    
    public StudentHistoryDTO getStudentHistory(Long studentId) {
        // 1. Fetch the student
        Etudiant etudiant = etudiantService.getUserById(studentId);
        if(etudiant==null) {
        	throw new RuntimeException("Student not found with ID: " + studentId);
        }

        // 2. Get all enrolled courses
        List<InscriptionCours> inscriptions = inscriptionCoursRepository.findByEtudiant(etudiant);
        if (inscriptions.isEmpty()) {
            return new StudentHistoryDTO(studentId, Collections.emptyList());
        }

        // 3. Build course history
        List<CoursHistoryDTO> coursHistory = inscriptions.stream()
                .map(inscription -> {
                    Cours cours = inscription.getCours();
                    List<Chapitre> chapitres = chapitreRepository.findByCours(cours);
                    List<ScoreChapitreDTO> chapitreScores = new ArrayList<ScoreChapitreDTO>();
                    for (Chapitre  chapitre  : chapitres) {
                    	ScoreChapitre score = scoreChapitreRepository.findByEtudiantAndChapitre(etudiant, chapitre);
                        chapitreScores.add( ScoreChapitreDTO.map(score));

					}
                   
                   

                    // Determine if the course is completed (all chapters have scores)
                    boolean isCompleted = chapitres.size() == chapitreScores.size() && chapitres.isEmpty();

                    // Create CoursHistoryDTO
                    return new CoursHistoryDTO(
                            cours.getId(),
                            cours.getTitre(),
                            inscription.getTotalScore(),
                            isCompleted,
                            chapitreScores
                    );
                })
                .collect(Collectors.toList());

        return new StudentHistoryDTO(studentId, coursHistory);
    }
}
