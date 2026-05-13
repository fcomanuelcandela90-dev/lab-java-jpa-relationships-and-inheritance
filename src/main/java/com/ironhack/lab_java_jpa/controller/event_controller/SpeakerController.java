package com.ironhack.lab_java_jpa.controller.event_controller;

import com.ironhack.lab_java_jpa.model.event_system.Speaker;
import com.ironhack.lab_java_jpa.service.event_service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/speakers")
@RequiredArgsConstructor
public class SpeakerController {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<Speaker>> getAllSpeakers() {
        return ResponseEntity.ok(eventService.getAllSpeakers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Speaker> getSpeakerById(@PathVariable Long id) {
        return eventService.getSpeakerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Speaker> createSpeaker(@RequestBody Speaker speaker) {
        Speaker created = eventService.createSpeaker(speaker);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Speaker> updateSpeaker(@PathVariable Long id, @RequestBody Speaker speaker) {
        return eventService.updateSpeaker(id, speaker)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Speaker> patchSpeaker(@PathVariable Long id, @RequestBody Speaker speaker) {
        return eventService.patchSpeaker(id, speaker)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpeaker(@PathVariable Long id) {
        if (eventService.deleteSpeaker(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}