package com.projet.ihm.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ihm.controller.dto.cours.DiciplineDTO;
import com.projet.ihm.controller.dto.cours.SpecialiteDto;
import com.projet.ihm.controller.request.dto.DiciplineRequestDTO;
import com.projet.ihm.controller.request.dto.SpecialiteRequestDto;
import com.projet.ihm.repo.DiciplineRepository;
import com.projet.ihm.repo.SpecialiteRepository;
import com.projet.ihm.repo.model.Dicipline;
import com.projet.ihm.repo.model.Specialite;


@Service
public class SpecialiteDiciplineService {

	
	 @Autowired
	 private SpecialiteRepository specialiteRepository;

	 @Autowired
	 private DiciplineRepository diciplineRepository;
	 
	 public List<Specialite> getAllSpecialites() {
        return specialiteRepository.findAll();
    }
	 
	public Specialite getSpecialiteById(Long id) {
    	Optional<Specialite> optional = specialiteRepository.findById(id) ;
        return optional.isPresent() ? optional.get(): null;
    }
	
	public SpecialiteDto updateSpecialite(Long id, SpecialiteRequestDto specialiteDto) {
		if(specialiteDto==null || id == null) {
            throw new RuntimeException("diciplineDTO or  id was not found");
		}
		if(StringUtils.isBlank(specialiteDto.getLabelle())) {
            throw new RuntimeException("specialite Label was not found");
		}
		if(specialiteRepository.findByLabelle(specialiteDto.getLabelle() )!= null ) {
            throw new RuntimeException("specialite Label already exists");
		}
		Dicipline dicipline = getDiciplineById(specialiteDto.getDiciplineId()) ;
		if(dicipline == null) {
            throw new RuntimeException(" dicipline was not found");

		}
		Specialite Specialite =getSpecialiteById(id) ;
		if(Specialite == null) {
            throw new RuntimeException("specialite  was not found");

		}
		Specialite.setDicipline(dicipline);
		Specialite.setImage(specialiteDto.getImage());
		Specialite.setLabelle(specialiteDto.getLabelle());
		

        return SpecialiteDto.map(specialiteRepository.save(Specialite));
    }
	
	public SpecialiteDto createSpecialite(SpecialiteRequestDto specialiteDto) {
		if(specialiteDto==null) {
            throw new RuntimeException("specialiteDto was not found");
		}
		if(StringUtils.isBlank(specialiteDto.getLabelle())) {
            throw new RuntimeException("specialite Label was not found");
		}
		if(specialiteRepository.findByLabelle(specialiteDto.getLabelle() )!= null ) {
            throw new RuntimeException("specialite Label already exists");
		}
		Dicipline dicipline = getDiciplineById(specialiteDto.getDiciplineId()) ;
		if(dicipline == null) {
            throw new RuntimeException(" dicipline was not found");

		}
		Specialite Specialite = new Specialite();
		Specialite.setDicipline(dicipline);
		Specialite.setImage(specialiteDto.getImage());
		Specialite.setLabelle(specialiteDto.getLabelle());
		

        return SpecialiteDto.map(specialiteRepository.save(Specialite));
    }
		 
	 ////////////////////////////////////////////////:
	 public List<Dicipline> getAllDiciplines() {
        return diciplineRepository.findAll();
    }
	 
	public Dicipline getDiciplineById(Long id) {
    	Optional<Dicipline> optional = diciplineRepository.findById(id) ;
        return optional.isPresent() ? optional.get(): null;
    }
	
	public DiciplineDTO updateDicipline(Long id,DiciplineRequestDTO diciplineDTO) {
		if(diciplineDTO==null ||  id == null) {
            throw new RuntimeException("diciplineDTO or  id was not found");
		}
		if(StringUtils.isBlank(diciplineDTO.getTitre())) {
            throw new RuntimeException("dicipline titre was not found");
		}
		if(diciplineRepository.findByTitre(diciplineDTO.getTitre() )!= null ) {
            throw new RuntimeException("dicipline titre already exists");
		}
	
		Dicipline dicipline = getDiciplineById(id);
		if(dicipline == null) {
            throw new RuntimeException("dicipline  was not found");

		}
		dicipline.setTitre(diciplineDTO.getTitre());
		dicipline.setImage(diciplineDTO.getImage());
		dicipline.setDescription(diciplineDTO.getDescription());
		

        return DiciplineDTO.map(diciplineRepository.save(dicipline));
    }
	
	
	public DiciplineDTO createDicipline(DiciplineRequestDTO diciplineDTO) {
		if(diciplineDTO==null) {
			 throw new RuntimeException("specialiteDto was not found");
		}
		if(StringUtils.isBlank(diciplineDTO.getTitre())) {
            throw new RuntimeException("dicipline titre was not found");
		}
		if(diciplineRepository.findByTitre(diciplineDTO.getTitre() )!= null ) {
            throw new RuntimeException("dicipline titre already exists");
		}
	
		Dicipline dicipline = new Dicipline();
		dicipline.setTitre(diciplineDTO.getTitre());
		dicipline.setImage(diciplineDTO.getImage());
		dicipline.setDescription(diciplineDTO.getDescription());
		

        return DiciplineDTO.map(diciplineRepository.save(dicipline));
    }

	
}
