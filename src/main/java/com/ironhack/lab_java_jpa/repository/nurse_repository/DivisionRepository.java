package com.ironhack.lab_java_jpa.repository.nurse_repository;

import com.ironhack.lab_java_jpa.model.nurse_management.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Long> {
    List<Division> findByDistrict(String district);
}
