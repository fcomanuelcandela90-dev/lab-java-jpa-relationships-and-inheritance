package com.ironhack.lab_java_jpa.service.public_relations_service;

import com.ironhack.lab_java_jpa.model.public_relations_system.Contact;
import com.ironhack.lab_java_jpa.repository.public_relations_repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Optional<Contact> updateContact(Long id, Contact contact) {
        Optional<Contact> existing = contactRepository.findById(id);
        if (existing.isPresent()) {
            Contact c = existing.get();
            c.setCompany(contact.getCompany());
            c.setTitle(contact.getTitle());
            c.setName(contact.getName());
            return Optional.of(contactRepository.save(c));
        }
        return Optional.empty();
    }

    public Optional<Contact> patchContact(Long id, Contact contact) {
        Optional<Contact> existing = contactRepository.findById(id);
        if (existing.isPresent()) {
            Contact c = existing.get();
            if (contact.getCompany() != null) c.setCompany(contact.getCompany());
            if (contact.getTitle() != null) c.setTitle(contact.getTitle());
            if (contact.getName() != null) c.setName(contact.getName());
            return Optional.of(contactRepository.save(c));
        }
        return Optional.empty();
    }

    public boolean deleteContact(Long id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Contact> getContactsByCompany(String company) {
        return contactRepository.findByCompany(company);
    }

    public List<Contact> getContactsByTitle(String title) {
        return contactRepository.findByTitle(title);
    }
}