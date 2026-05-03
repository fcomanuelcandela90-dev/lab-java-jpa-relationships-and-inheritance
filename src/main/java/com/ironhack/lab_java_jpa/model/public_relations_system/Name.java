package com.ironhack.lab_java_jpa.model.public_relations_system;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Name {
    public String salutation;
    public String firstName;
    public String middleName;
    public String lastName;
}
