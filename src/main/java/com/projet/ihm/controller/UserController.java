package com.projet.ihm.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ihm.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "API for managing users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get IsBlocked user by ID", description = "Retrieve whether a user is blocked by their ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getIsBlocked(
            @Parameter(description = "ID of the user to retrieve") @PathVariable Long id) {

        if (id == null) {
            return ResponseEntity.badRequest().body("ID was not provided");
        }

        Boolean isBlocked = userService.getIsBlocked(id);
        
        if (isBlocked == null) {
            return ResponseEntity.badRequest().body("User was not found");
        }

        Map<String, Boolean> response = new HashMap<>();
        response.put("isBlocked", isBlocked);

        return ResponseEntity.ok(response);
    }
   
    @Operation(summary = "Block or Unblock a User", description = "Update the isBlocked status of a user")
    @PutMapping("/{id}/block")
    public ResponseEntity<?> updateUserBlockStatus(
            @Parameter(description = "ID of the user to update") @PathVariable Long id,
            @RequestParam Boolean isBlocked) {

        if (id == null) {
            return ResponseEntity.badRequest().body("ID was not provided");
        }

        boolean updated = userService.updateIsBlocked(id, isBlocked);

        if (!updated) {
            return ResponseEntity.badRequest().body("User was not found");
        }

        Map<String, Boolean> response = new HashMap<>();
        response.put("updated", updated);
        
        return ResponseEntity.ok(response);
    }

  
}