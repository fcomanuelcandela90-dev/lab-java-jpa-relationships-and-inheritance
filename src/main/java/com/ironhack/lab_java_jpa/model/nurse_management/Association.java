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
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "association_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "association_name")
    private String name;

    @OneToMany(mappedBy = "association")
    private List<Division> divisions;


}
