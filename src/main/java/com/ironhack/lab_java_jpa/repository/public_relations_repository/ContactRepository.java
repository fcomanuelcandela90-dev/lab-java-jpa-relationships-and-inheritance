package com.ironhack.lab_java_jpa.repository.public_relations_repository;

import com.ironhack.lab_java_jpa.model.public_relations_system.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByCompany(String company);
    List<Contact> findByTitle(String title);
}
