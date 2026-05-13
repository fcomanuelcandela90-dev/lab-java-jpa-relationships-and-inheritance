package com.ironhack.lab_java_jpa.service.nurse_service;

import com.ironhack.lab_java_jpa.enums.nurse_management.Status;
import com.ironhack.lab_java_jpa.model.nurse_management.Association;
import com.ironhack.lab_java_jpa.model.nurse_management.Division;
import com.ironhack.lab_java_jpa.model.nurse_management.Member;
import com.ironhack.lab_java_jpa.repository.nurse_repository.AssociationRepository;
import com.ironhack.lab_java_jpa.repository.nurse_repository.DivisionRepository;
import com.ironhack.lab_java_jpa.repository.nurse_repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssociationService {

    private final AssociationRepository associationRepository;
    private final DivisionRepository divisionRepository;
    private final MemberRepository memberRepository;

    public List<Association> getAllAssociations() {
        return associationRepository.findAll();
    }

    public Optional<Association> getAssociationById(Long id) {
        return associationRepository.findById(id);
    }

    public Association createAssociation(Association association) {
        return associationRepository.save(association);
    }

    public Optional<Association> updateAssociation(Long id, Association association) {
        Optional<Association> existing = associationRepository.findById(id);
        if (existing.isPresent()) {
            Association a = existing.get();
            a.setName(association.getName());
            return Optional.of(associationRepository.save(a));
        }
        return Optional.empty();
    }

    public Optional<Association> patchAssociation(Long id, Association association) {
        Optional<Association> existing = associationRepository.findById(id);
        if (existing.isPresent()) {
            Association a = existing.get();
            if (association.getName() != null) a.setName(association.getName());
            return Optional.of(associationRepository.save(a));
        }
        return Optional.empty();
    }

    public boolean deleteAssociation(Long id) {
        if (associationRepository.existsById(id)) {
            associationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }

    public Optional<Division> getDivisionById(Long id) {
        return divisionRepository.findById(id);
    }

    public List<Division> getDivisionsByDistrict(String district) {
        return divisionRepository.findByDistrict(district);
    }

    public Division createDivision(Division division) {
        return divisionRepository.save(division);
    }

    public Optional<Division> updateDivision(Long id, Division division) {
        Optional<Division> existing = divisionRepository.findById(id);
        if (existing.isPresent()) {
            Division d = existing.get();
            d.setName(division.getName());
            d.setDistrict(division.getDistrict());
            d.setPresident(division.getPresident());
            return Optional.of(divisionRepository.save(d));
        }
        return Optional.empty();
    }

    public Optional<Division> patchDivision(Long id, Division division) {
        Optional<Division> existing = divisionRepository.findById(id);
        if (existing.isPresent()) {
            Division d = existing.get();
            if (division.getName() != null) d.setName(division.getName());
            if (division.getDistrict() != null) d.setDistrict(division.getDistrict());
            if (division.getPresident() != null) d.setPresident(division.getPresident());
            return Optional.of(divisionRepository.save(d));
        }
        return Optional.empty();
    }

    public boolean deleteDivision(Long id) {
        if (divisionRepository.existsById(id)) {
            divisionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Optional<Member> updateMember(Long id, Member member) {
        Optional<Member> existing = memberRepository.findById(id);
        if (existing.isPresent()) {
            Member m = existing.get();
            m.setName(member.getName());
            m.setStatus(member.getStatus());
            m.setRenewalDate(member.getRenewalDate());
            m.setDivision(member.getDivision());
            return Optional.of(memberRepository.save(m));
        }
        return Optional.empty();
    }

    public Optional<Member> patchMember(Long id, Member member) {
        Optional<Member> existing = memberRepository.findById(id);
        if (existing.isPresent()) {
            Member m = existing.get();
            if (member.getName() != null) m.setName(member.getName());
            if (member.getStatus() != null) m.setStatus(member.getStatus());
            if (member.getRenewalDate() != null) m.setRenewalDate(member.getRenewalDate());
            if (member.getDivision() != null) m.setDivision(member.getDivision());
            return Optional.of(memberRepository.save(m));
        }
        return Optional.empty();
    }

    public boolean deleteMember(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
            return true;
        }
        return false;
    }
}