package com.projet.ihm.controller.request.dto;

public class UtilisateurLightDto {

  
	 
    private String password;

    private String email;
    
  

	public UtilisateurLightDto(String password,	String email) {
		super();
		
		this.password = password;
		this.email = email;
	
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
    
    
}
