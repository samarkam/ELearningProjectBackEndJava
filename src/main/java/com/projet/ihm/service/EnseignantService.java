package com.projet.ihm.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.projet.ihm.repo.EnseignantRepository;
import com.projet.ihm.repo.model.Enseignant;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EnseignantService {
    @Autowired
    private EnseignantRepository userRepository;

    public List<Enseignant> getAllUsers() {
        return userRepository.findAll();
    }

    public Enseignant getUserByEmail(String email) {
        return userRepository.findByEmail(email)  ;
    } 
    
    public Enseignant getUserById(Long id) {
    	Optional<Enseignant> optional = userRepository.findById(id) ;
        return optional.isPresent() ? optional.get(): null;
    }

    public Enseignant updateUser(Enseignant user) {
    	if(user.getId() ==null) {
			throw new RuntimeException("User ID missing");

    	}
    	
    	Enseignant existingUser= getUserById(user.getId());
		if(existingUser==null) {
			throw new RuntimeException("User with ID " + user.getId() + " not found");
		}
		if(StringUtils.isBlank(user.getEmail())) {
			throw new RuntimeException("User email does not exists");
    	}
		Enseignant userWithEmail = getUserByEmail(user.getEmail());
	    if (userWithEmail != null && !userWithEmail.getId().equals(user.getId())) {
	        throw new RuntimeException("User email already exists");
	    }
		if(!isValidEmail(user.getEmail())) {
			throw new RuntimeException("User email is not valid email");
    	}
		
		existingUser.setNom(user.getNom());
   		 existingUser.setPrenom(user.getPrenom());
   		 existingUser.setEmail(user.getEmail());
   		 existingUser.setTelephone(user.getTelephone());
   		 existingUser.setDateDeNaissance(user.getDateDeNaissance());
   		 existingUser.setPassword(user.getPassword());
   		 existingUser.setDetails(user.getDetails());
   		 existingUser.setMatricule(user.getMatricule());
   		 existingUser.setSpecialite(user.getSpecialite());
   		 
         return userRepository.save(existingUser);

    }

    public Enseignant saveUser(Enseignant user) {
    	
    	if(user.getId() !=null) {
			throw new RuntimeException("User ID must not exist");

    	}
    	if(StringUtils.isBlank(user.getEmail())) {
			throw new RuntimeException("User email does not exists");
    	}
    	if(getUserByEmail(user.getEmail()) != null ) {
			throw new RuntimeException("User email already exists");

    	}
    	if(!isValidEmail(user.getEmail())) {
			throw new RuntimeException("User email is not valid email");
    	}
    	
    	
    	
    	
        try {
        	return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Database constraint violated: " + e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error occurred while saving user"+e);
        }
    
    }
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}