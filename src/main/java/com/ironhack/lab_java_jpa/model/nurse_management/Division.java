package com.ironhack.lab_java_jpa.model.nurse_management;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id", nullable = false)
    private Long id;

    @Column(name = "division_name")
    private String name;

    @Column(name = "division_district")
    private String district;

    @OneToOne
    @JoinColumn(name = "division_president_id")
    private Member president;

    @OneToMany(mappedBy = "division")
    private List<Member> members;

    @ManyToOne
    @JoinColumn(name = "association_id")
    private Association association;
}
