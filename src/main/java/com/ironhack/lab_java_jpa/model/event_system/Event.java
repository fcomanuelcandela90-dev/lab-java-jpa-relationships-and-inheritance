package com.ironhack.lab_java_jpa.model.event_system;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "event_title")
    private String title;

    @Column(name = "event_date")
    private LocalDate date;

    @Column(name = "event_duration")
    private Integer duration;

    @Column(name = "event_location")
    private String location;

    @OneToMany(mappedBy = "event")
    private List<Guest> guests;
}
