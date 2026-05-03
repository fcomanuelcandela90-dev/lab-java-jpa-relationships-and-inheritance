package com.ironhack.lab_java_jpa.repository.nurse_repository;

import com.ironhack.lab_java_jpa.model.nurse_management.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {
}
