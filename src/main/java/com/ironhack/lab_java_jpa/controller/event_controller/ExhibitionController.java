package com.ironhack.lab_java_jpa.controller.event_controller;

import com.ironhack.lab_java_jpa.model.event_system.Exhibition;
import com.ironhack.lab_java_jpa.service.event_service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exhibitions")
@RequiredArgsConstructor
public class ExhibitionController {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<Exhibition>> getAllExhibitions() {
        return ResponseEntity.ok(eventService.getAllExhibitions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exhibition> getExhibitionById(@PathVariable Long id) {
        return eventService.getExhibitionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Exhibition> createExhibition(@RequestBody Exhibition exhibition) {
        Exhibition created = eventService.createExhibition(exhibition);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exhibition> updateExhibition(@PathVariable Long id, @RequestBody Exhibition exhibition) {
        return eventService.updateExhibition(id, exhibition)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Exhibition> patchExhibition(@PathVariable Long id, @RequestBody Exhibition exhibition) {
        return eventService.patchExhibition(id, exhibition)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExhibition(@PathVariable Long id) {
        if (eventService.deleteExhibition(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}