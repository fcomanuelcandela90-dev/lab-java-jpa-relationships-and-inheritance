package com.ironhack.lab_java_jpa.model.nurse_management;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ironhack.lab_java_jpa.enums.nurse_management.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "member_name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "renewal_date", nullable = false)
    private LocalDate renewalDate;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;
}
