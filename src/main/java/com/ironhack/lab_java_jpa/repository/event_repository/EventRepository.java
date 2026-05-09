package com.ironhack.lab_java_jpa.repository.event_repository;

import com.ironhack.lab_java_jpa.model.event_system.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
