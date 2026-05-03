package com.ironhack.lab_java_jpa.model.event_system;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "event_id")
public class Conference extends Event {

    @OneToMany(mappedBy = "conference")
    private List<Speaker> speakers;

}
