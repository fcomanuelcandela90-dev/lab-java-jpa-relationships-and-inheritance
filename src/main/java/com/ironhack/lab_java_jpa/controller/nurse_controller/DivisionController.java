package com.ironhack.lab_java_jpa.controller.nurse_controller;

import com.ironhack.lab_java_jpa.model.nurse_management.Division;
import com.ironhack.lab_java_jpa.service.nurse_service.AssociationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/divisions")
@RequiredArgsConstructor
public class DivisionController {

    private final AssociationService associationService;

    @GetMapping
    public ResponseEntity<List<Division>> getAllDivisions() {
        return ResponseEntity.ok(associationService.getAllDivisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Division> getDivisionById(@PathVariable Long id) {
        return associationService.getDivisionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/district/{district}")
    public ResponseEntity<List<Division>> getDivisionsByDistrict(@PathVariable String district) {
        return ResponseEntity.ok(associationService.getDivisionsByDistrict(district));
    }

    @PostMapping
    public ResponseEntity<Division> createDivision(@RequestBody Division division) {
        Division created = associationService.createDivision(division);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Division> updateDivision(@PathVariable Long id, @RequestBody Division division) {
        return associationService.updateDivision(id, division)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Division> patchDivision(@PathVariable Long id, @RequestBody Division division) {
        return associationService.patchDivision(id, division)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDivision(@PathVariable Long id) {
        if (associationService.deleteDivision(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}