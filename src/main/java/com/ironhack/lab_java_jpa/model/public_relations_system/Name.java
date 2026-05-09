package com.ironhack.lab_java_jpa.model.public_relations_system;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Name {
    @Column(name = "salutation", nullable = false)
    public String salutation;
    @Column(name = "first_name", nullable = false)
    public String firstName;
    @Column(name = "middle_name", nullable = false)
    public String middleName;
    @Column(name = "last_name", nullable = false)
    public String lastName;
}
