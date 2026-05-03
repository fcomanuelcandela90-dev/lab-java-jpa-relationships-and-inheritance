package com.ironhack.lab_java_jpa.repository.nurse_repository;

import com.ironhack.lab_java_jpa.model.nurse_management.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
