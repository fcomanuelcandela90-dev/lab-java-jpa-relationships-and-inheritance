package com.ironhack.lab_java_jpa.repository.event_repository;

import com.ironhack.lab_java_jpa.enums.event_system.GuestStatus;
import com.ironhack.lab_java_jpa.model.event_system.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByStatus(GuestStatus status);
}
