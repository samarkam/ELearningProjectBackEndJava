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

import com.projet.ihm.controller.dto.cours.SpecialiteDto;
import com.projet.ihm.controller.request.dto.SpecialiteRequestDto;
import com.projet.ihm.repo.model.Specialite;
import com.projet.ihm.service.SpecialiteDiciplineService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/specialite")
@Tag(name = "Specialite Management", description = "CRUD operations for Specialite")
public class SpecialiteController {

    @Autowired
    private SpecialiteDiciplineService specialiteDiciplineService;

    @Operation(summary = "Create a new specialite (teacher only)")
    @PostMapping("")
    public ResponseEntity<?> createSpecialite(@RequestBody SpecialiteRequestDto specialiteRequestDto) {
        try {
            SpecialiteDto specialiteDto = specialiteDiciplineService.createSpecialite(specialiteRequestDto);
            return ResponseEntity.ok(specialiteDto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Get all specialites")
    @GetMapping("")
    public ResponseEntity<List<SpecialiteDto>> getAllSpecialites() {
        List<Specialite> specialites = specialiteDiciplineService.getAllSpecialites();
        return ResponseEntity.ok(specialites==null || specialites.isEmpty() ? null : specialites.stream().map(SpecialiteDto::map).collect(Collectors.toList()));
    }

    @Operation(summary = "Get a specialite by ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getSpecialiteById(@PathVariable Long id) {
        try {
            Specialite specialite = specialiteDiciplineService.getSpecialiteById(id);
            return ResponseEntity.ok(SpecialiteDto.map(specialite));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Operation(summary = "Update a specialite by ID (teacher only)")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSpecialite(@PathVariable Long id, @RequestBody SpecialiteRequestDto specialiteRequestDto) {
        try {
            SpecialiteDto updatedSpecialite = specialiteDiciplineService.updateSpecialite(id, specialiteRequestDto);
            return ResponseEntity.ok(updatedSpecialite);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

  
}
