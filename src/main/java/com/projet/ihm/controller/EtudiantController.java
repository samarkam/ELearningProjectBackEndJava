package com.projet.ihm.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ihm.controller.dto.EtudiantDto;
import com.projet.ihm.controller.dto.EtudiantRequestDto;
import com.projet.ihm.controller.request.dto.UtilisateurRequestDto;
import com.projet.ihm.repo.model.Etudiant;
import com.projet.ihm.service.EtudiantService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {
	
	
	 @Autowired
	    private EtudiantService userService;

	    @Operation(summary = "Get all users", description = "Retrieve a list of all users")
	    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
	    @GetMapping("/list")
	    public List<EtudiantDto> getAllUsers() {
	        return userService.getAllUsers().stream().map(EtudiantDto::mapWithInscriptionAndScoreChapters).collect(Collectors.toList());
	    }

	    @Operation(summary = "Get user by ID", description = "Retrieve a single user by their ID")
	   
	    @GetMapping("/{id}")
	    public ResponseEntity<?> getUserById(
	            @Parameter(description = "ID of the user to retrieve") @PathVariable Long id) {
	    		if(id == null ) {
	    			return ResponseEntity.badRequest().body("ID was not found");
	    		}
	    		Etudiant utilisateur =  userService.getUserById(id) ;
	    	   return utilisateur== null ? ResponseEntity.badRequest().body("User was not found"): ResponseEntity.ok(EtudiantDto.mapWithInscriptionAndScoreChapters(utilisateur)) ;
	    }

	    @Operation(summary = "Create a new user", description = "Add a new user to the system")
	    @PostMapping(value="/new")
	    public ResponseEntity<?> createUser(@RequestBody UtilisateurRequestDto user) {
	    	
	    	Etudiant utilisateur = new Etudiant();
	    	utilisateur.setNom(user.getNom());
	    	utilisateur.setPrenom(user.getPrenom());
	    	utilisateur.setEmail(user.getEmail());
	    	utilisateur.setTelephone(user.getTelephone());
	    	utilisateur.setDateDeNaissance(user.getDateDeNaissance());
	    	utilisateur.setPassword(user.getPassword());
	    	utilisateur.setDetails(user.getDetails());
	    	utilisateur.setNiveauEtude(user.getNiveauEtude());

	    
		   	try {
		   		Etudiant savedUser =  userService.saveUser(utilisateur);
				return ResponseEntity.ok(EtudiantDto.mapWithInscriptionAndScoreChapters(savedUser)) ;
			} catch (RuntimeException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
	    }
	    
	    @Operation(summary = "Update user", description = "Update a  user in the system")
	    @PutMapping(value="/update"  )
	    public ResponseEntity<?> updateUser(@RequestBody EtudiantRequestDto user) {
	    	
	    	Etudiant utilisateur =  userService.getUserById(user.getId()) ;

	 	   if(utilisateur==null) {
	 		   return ResponseEntity.badRequest().body("User was not found");
	 	   }
	 	  if (StringUtils.isNotBlank(user.getNom())) {
	 		    utilisateur.setNom(user.getNom());
	 		}
	 		if (StringUtils.isNotBlank(user.getPrenom())) {
	 		    utilisateur.setPrenom(user.getPrenom());
	 		}
	 		if (StringUtils.isNotBlank(user.getEmail())) {
	 		    utilisateur.setEmail(user.getEmail());
	 		}
	 		if (StringUtils.isNotBlank(user.getTelephone())) {
	 		    utilisateur.setTelephone(user.getTelephone());
	 		}
	 		if (user.getDateDeNaissance() != null) {
	 		    utilisateur.setDateDeNaissance(user.getDateDeNaissance());
	 		}
	 		if (StringUtils.isNotBlank(user.getPassword())) {
	 		    utilisateur.setPassword(user.getPassword());
	 		}
	 		if (StringUtils.isNotBlank(user.getDetails())) {
	 		    utilisateur.setDetails(user.getDetails());
	 		}
	 		if (StringUtils.isNotBlank(user.getNiveauEtude())) {
	 		    utilisateur.setNiveauEtude(user.getNiveauEtude());
	 		}
	 		if (StringUtils.isNotBlank(user.getImage())) {
	 		    utilisateur.setImage(user.getImage());
	 		}
	    	
	    	try {
		   		Etudiant savedUser =  userService.updateUser(utilisateur);
				return ResponseEntity.ok(EtudiantDto.mapWithInscriptionAndScoreChapters(savedUser)) ;
			} catch (RuntimeException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
	    
	    }

}
