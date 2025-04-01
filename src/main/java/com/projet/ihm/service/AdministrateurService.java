package com.projet.ihm.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.projet.ihm.repo.AdministrateurRepository;
import com.projet.ihm.repo.model.Administrateur;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdministrateurService {
    @Autowired
    private AdministrateurRepository userRepository;

    public List<Administrateur> getAllUsers() {
        return userRepository.findAll();
    }

    public Administrateur getUserByEmail(String email) {
        return userRepository.findByEmail(email)  ;
    } 
    
    public Administrateur getUserById(Long id) {
    	Optional<Administrateur> optional = userRepository.findById(id) ;
        return optional.isPresent() ? optional.get(): null;
    }

    public Administrateur updateUser(Administrateur user) {
    	if(user.getId() ==null) {
			throw new RuntimeException("User ID missing");

    	}
    	
    	Administrateur existingUser= getUserById(user.getId());
		if(existingUser==null) {
			throw new RuntimeException("User with ID " + user.getId() + " not found");
		}
		if(StringUtils.isBlank(user.getEmail())) {
			throw new RuntimeException("User email does not exists");
    	}
		Administrateur userWithEmail = getUserByEmail(user.getEmail());
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
         return userRepository.save(existingUser);

    }

    public Administrateur saveUser(Administrateur user) {
    	
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