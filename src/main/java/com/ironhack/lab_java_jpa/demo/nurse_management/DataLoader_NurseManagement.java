package com.ironhack.lab_java_jpa.demo.nurse_management;

import com.ironhack.lab_java_jpa.enums.nurse_management.Status;
import com.ironhack.lab_java_jpa.model.nurse_management.Association;
import com.ironhack.lab_java_jpa.model.nurse_management.Division;
import com.ironhack.lab_java_jpa.model.nurse_management.Member;
import com.ironhack.lab_java_jpa.repository.nurse_repository.AssociationRepository;
import com.ironhack.lab_java_jpa.repository.nurse_repository.DivisionRepository;
import com.ironhack.lab_java_jpa.repository.nurse_repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader_NurseManagement implements CommandLineRunner {

    private final AssociationRepository associationRepository;
    private final DivisionRepository divisionRepository;
    private final MemberRepository memberRepository;

    public DataLoader_NurseManagement(AssociationRepository associationRepository, DivisionRepository divisionRepository, MemberRepository memberRepository) {
        this.associationRepository = associationRepository;
        this.divisionRepository = divisionRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Amazon Care association data...");
        Association amazonCare = new Association();
        amazonCare.setName("Amazon Care");
        amazonCare = associationRepository.save(amazonCare);

        List<String> awsRegions = Arrays.asList(
                "us-east-1 (N. Virginia)",
                "eu-west-1 (Ireland)",
                "eu-south-2 (Spain)",
                "ap-northeast-1 (Tokyo)",
                "sa-east-1 (São Paulo)",
                "ca-central-1 (Canada)",
                "af-south-1 (Cape Town)"
        );

        for (String region : awsRegions) {
            Division division = new Division();
            division.setName("AWS Medical Team");
            division.setDistrict(region);
            division.setAssociation(amazonCare);
            division = divisionRepository.save(division);

            Member presidentNurse = new Member();
            presidentNurse.setName("Head Nurse - " + region);
            presidentNurse.setStatus(Status.ACTIVE);
            presidentNurse.setRenewalDate(LocalDate.now().plusYears(1));
            presidentNurse.setDivision(division);
            memberRepository.save(presidentNurse);

            division.setPresident(presidentNurse);
            division = divisionRepository.save(division);
        }

        System.out.println("Amazon Care association data loaded successfully in MYSQL");
    }
}
