package com.projet.ihm.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ihm.controller.dto.cours.DiciplineDTO;
import com.projet.ihm.controller.request.dto.DiciplineRequestDTO;
import com.projet.ihm.repo.model.Dicipline;
import com.projet.ihm.service.SpecialiteDiciplineService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/dicipline")
@Tag(name = "Dicipline Management", description = "CRUD operations for Dicipline")
public class DiciplineController {

	 @Autowired
	 private SpecialiteDiciplineService specialiteDiciplineService;
	 
	 @Operation(summary = "Create a new dicipline (teacher only)")
	 @PostMapping
	 public ResponseEntity<?> createDicipline(@RequestBody DiciplineRequestDTO diciplineRequestDTO) {
        try {
            DiciplineDTO dicipline = specialiteDiciplineService.createDicipline(diciplineRequestDTO);
            return ResponseEntity.ok(dicipline);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Get all diciplines")
    @GetMapping
    public ResponseEntity<List<DiciplineDTO>> getAllDiciplines() {
        List<Dicipline> diciplines = specialiteDiciplineService.getAllDiciplines();
        return ResponseEntity.ok(diciplines == null || diciplines.isEmpty() ? null : 
                                 diciplines.stream().map(DiciplineDTO::map).collect(Collectors.toList()));
    }

    @Operation(summary = "Get a dicipline by ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getDiciplineById(@PathVariable Long id) {
        try {
            Dicipline dicipline = specialiteDiciplineService.getDiciplineById(id);
            return ResponseEntity.ok(DiciplineDTO.map(dicipline));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Operation(summary = "Update a dicipline by ID (teacher only)")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDicipline(@PathVariable Long id, @RequestBody DiciplineRequestDTO diciplineRequestDTO) {
        try {
            DiciplineDTO updatedDicipline = specialiteDiciplineService.updateDicipline(id, diciplineRequestDTO);
            return ResponseEntity.ok(updatedDicipline);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

   
}
