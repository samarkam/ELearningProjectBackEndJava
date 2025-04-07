package com.projet.ihm.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ihm.controller.dto.AdministrateurDto;
import com.projet.ihm.controller.dto.EnseignantDto;
import com.projet.ihm.controller.dto.EtudiantDto;
import com.projet.ihm.controller.request.dto.UtilisateurLightDto;
import com.projet.ihm.repo.model.Administrateur;
import com.projet.ihm.repo.model.Enseignant;
import com.projet.ihm.repo.model.Etudiant;
import com.projet.ihm.repo.model.Utilisateur;
import com.projet.ihm.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "User Authentification Management")
public class AuthController {

    @Autowired
    private UserService userService;

   

 
    
    @Operation(summary = "Auth user", description = "Auth")
    @PostMapping
    public ResponseEntity<?> authUser(@RequestBody UtilisateurLightDto user) {
    	
    	if(StringUtils.isBlank(user.getEmail())) {
    		return ResponseEntity.badRequest().body("User Email was not found");
    	}
    	if(StringUtils.isBlank(user.getPassword())) {
    		return ResponseEntity.badRequest().body("User Password was not found");
    	}
 	   Utilisateur utilisateur =  userService.getUserByEmail(user.getEmail()) ;

 	   if(utilisateur==null) {
 		   return ResponseEntity.badRequest().body("User was not found");
 	   }
 	  if(StringUtils.isNotBlank(utilisateur.getPassword()) && utilisateur.getPassword().equals(user.getPassword())) {
 		  if(utilisateur  instanceof Administrateur) {
 		  		return ResponseEntity.ok(AdministrateurDto.map((Administrateur)utilisateur));
 		  }else if(utilisateur  instanceof Etudiant) {
		  		return ResponseEntity.ok(EtudiantDto.mapWithInscriptionAndScoreChapters((Etudiant)utilisateur));
		  }else if(utilisateur  instanceof Enseignant) {
		  		return ResponseEntity.ok(EnseignantDto.map((Enseignant)utilisateur));
		  }
 	    	return  ResponseEntity.badRequest().body("User Authentication failed");

 	  }
         
    	return  ResponseEntity.badRequest().body("User Authentication failed");
    }

  
}