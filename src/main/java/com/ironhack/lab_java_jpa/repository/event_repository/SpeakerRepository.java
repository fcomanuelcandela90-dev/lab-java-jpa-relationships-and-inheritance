package com.ironhack.lab_java_jpa.repository.event_repository;

import com.ironhack.lab_java_jpa.model.event_system.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
