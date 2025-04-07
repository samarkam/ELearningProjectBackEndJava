package com.projet.ihm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ihm.controller.dto.cours.ChapitreDTO;
import com.projet.ihm.controller.dto.cours.CoursDTO;
import com.projet.ihm.controller.dto.cours.InscriptionCoursDto;
import com.projet.ihm.controller.dto.cours.QuizDTO;
import com.projet.ihm.controller.dto.cours.QuizSubmissionDTO;
import com.projet.ihm.controller.dto.cours.ResourceDTO;
import com.projet.ihm.controller.request.dto.ChapitreRequestDTO;
import com.projet.ihm.controller.request.dto.CoursRequestDTO;
import com.projet.ihm.controller.request.dto.QuizRequestDTO;
import com.projet.ihm.controller.request.dto.ResourceRequestDTO;
import com.projet.ihm.service.CoursService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;
  

    @GetMapping("/list/light")
    @Operation(summary = " Get all courses (light version - basic info only)")
    public ResponseEntity<List<CoursDTO>> getAllCoursesLight() {
        return ResponseEntity.ok(coursService.getAllCoursesLight());
    }

    @GetMapping("/list")
    @Operation(summary = "Get all courses (full details)")
    public ResponseEntity<List<CoursDTO>> getAllCourses() {
        return ResponseEntity.ok(coursService.getAllCourses());
    }

    @Operation(summary = "Get courses based on user role (teacher's prepared courses or student's enrolled courses)")
    @GetMapping("/my-courses")
    public ResponseEntity<?> getMyCourses(String email) {
    	try {
    		List<CoursDTO> coursList = coursService.getMyCourses(email);
            return  ResponseEntity.ok(coursList);

		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
    }
   
    
    
    @Operation(summary = "Create a new course (teacher only)")
    @PostMapping("/cours/new")
    public ResponseEntity<?> createCourse(@RequestBody CoursRequestDTO coursDTO) {
    	try {
			CoursDTO cours= coursService.createCourse(coursDTO);
			return  ResponseEntity.ok(cours);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

    }
    
    @Operation(summary = "Update a  course (teacher only)")
    @PutMapping("/cours/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Long id,@RequestBody CoursRequestDTO coursDTO) {
    	try {
			CoursDTO cours= coursService.updateCourse(id,coursDTO);
			return  ResponseEntity.ok(cours);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

    }


    @Operation(summary = "Create a new chapter (teacher only)")
    @PostMapping("/chapitre/new")
    public ResponseEntity<?> createChapitre(@RequestBody ChapitreRequestDTO chapitreDTO) {
    	try {
    		ChapitreDTO cours= coursService.createChapitre(chapitreDTO);
			return  ResponseEntity.ok(cours);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
       
    }
    
    @Operation(summary = "Update a  chapter (teacher only)")
    @PutMapping("/chapitre/{id}")
    public ResponseEntity<?> updateChapitre(@PathVariable Long id,@RequestBody ChapitreRequestDTO chapitreDTO) {
    	try {
    		ChapitreDTO cours= coursService.updateChapitre(id, chapitreDTO);
			return  ResponseEntity.ok(cours);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

    }

    @Operation(summary = "Create a new Resource (teacher only)")
    @PostMapping("/resource/new")
    public ResponseEntity<?> createResource(@RequestBody ResourceRequestDTO chapitreDTO) {
    	try {
    		ResourceDTO cours= coursService.createRessource(chapitreDTO);
			return  ResponseEntity.ok(cours);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
       
    }
    
    @Operation(summary = "Update a  Resource (teacher only)")
    @PutMapping("/resource/{id}")
    public ResponseEntity<?> updateResource(@PathVariable Long id,@RequestBody ResourceRequestDTO chapitreDTO) {
    	try {
    		ResourceDTO cours= coursService.updateRessource(id, chapitreDTO);
			return  ResponseEntity.ok(cours);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

    }
    
    @Operation(summary = "Create a new Quiz (teacher only)")
    @PostMapping("/quiz/new")
    public ResponseEntity<?> createQuiz(@RequestBody QuizRequestDTO chapitreDTO) {
    	try {
    		QuizDTO cours= coursService.createQuiz(chapitreDTO);
			return  ResponseEntity.ok(cours);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
       
    }
    
    @Operation(summary = "Update a  Quiz (teacher only)")
    @PutMapping("/quiz/{id}")
    public ResponseEntity<?> updateQuiz(@PathVariable Long id,@RequestBody QuizRequestDTO chapitreDTO) {
    	try {
    		QuizDTO cours= coursService.updateQuiz(id, chapitreDTO);
			return  ResponseEntity.ok(cours);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

    }


    @Operation(summary = "Student inscription in a course")
    @GetMapping("/inscription")
    public ResponseEntity<?> inscriptionCours(@RequestParam Long etudiantId,@RequestParam Long coursId) {
    	try {
			InscriptionCoursDto inscriptionCoursDto = coursService.inscriptionCours(etudiantId,coursId);
			return ResponseEntity.ok(inscriptionCoursDto);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
    }

    @Operation(summary = "View course details")
    @GetMapping("/{id}")
    public ResponseEntity<CoursDTO> getCourseDetails(@PathVariable Long id) {
        return ResponseEntity.ok(CoursDTO.mapFullCours(coursService.getCoursById(id)));
    }

    

    @PostMapping("/quiz/submit")
    public ResponseEntity<?> submitQuiz(@RequestBody QuizSubmissionDTO submission) {
        
    	try {
    		return ResponseEntity.ok(coursService.submitQuiz(submission));
	    } catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
	
		}
    }

    @GetMapping("/history/student/{studentId}")
    public ResponseEntity<?> getStudentHistory(@PathVariable Long studentId) {
    	try {
            return ResponseEntity.ok(coursService.getStudentHistory(studentId));
	    } catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
	
		}
    }

    @Operation(summary = "update Course Active status by Admin")
    @PutMapping("/{id}/toggle-active")
    public ResponseEntity<?> toggleCourseActive(
            @Parameter(description = "ID of the cours to update") @PathVariable Long id,
            @RequestParam Boolean isActive) {

        if (id == null) {
            return ResponseEntity.badRequest().body("ID was not provided");
        }

        boolean updated = coursService.updateIsActive(id, isActive);

        if (!updated) {
            return ResponseEntity.badRequest().body("cours was not found");
        }

        Map<String, Boolean> response = new HashMap<>();
        response.put("updated", updated);
        
        return ResponseEntity.ok(response);
    }
    
    @Operation(summary = "update Course published status by teacher")
    @PutMapping("/{id}/toggle-published")
    public ResponseEntity<?> toggleCoursePublished(
            @Parameter(description = "ID of the cours to update") @PathVariable Long id,
            @RequestParam Boolean isPublished) {

        if (id == null) {
            return ResponseEntity.badRequest().body("ID was not provided");
        }

        boolean updated = coursService.updateIsPublished(id, isPublished);

        if (!updated) {
            return ResponseEntity.badRequest().body("cours was not found");
        }

        Map<String, Boolean> response = new HashMap<>();
        response.put("updated", updated);
        
        return ResponseEntity.ok(response);
    }
}