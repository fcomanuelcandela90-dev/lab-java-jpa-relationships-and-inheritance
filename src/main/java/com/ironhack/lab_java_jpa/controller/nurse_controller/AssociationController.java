package com.ironhack.lab_java_jpa.controller.nurse_controller;

import com.ironhack.lab_java_jpa.model.nurse_management.Association;
import com.ironhack.lab_java_jpa.service.nurse_service.AssociationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/associations")
@RequiredArgsConstructor
public class AssociationController {

    private final AssociationService associationService;

    @GetMapping
    public ResponseEntity<List<Association>> getAllAssociations() {
        return ResponseEntity.ok(associationService.getAllAssociations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Association> getAssociationById(@PathVariable Long id) {
        return associationService.getAssociationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Association> createAssociation(@RequestBody Association association) {
        Association created = associationService.createAssociation(association);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Association> updateAssociation(@PathVariable Long id, @RequestBody Association association) {
        return associationService.updateAssociation(id, association)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Association> patchAssociation(@PathVariable Long id, @RequestBody Association association) {
        return associationService.patchAssociation(id, association)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssociation(@PathVariable Long id) {
        if (associationService.deleteAssociation(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}