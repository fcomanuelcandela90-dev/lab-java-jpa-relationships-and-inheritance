package com.ironhack.lab_java_jpa.model.event_system;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "event_id")
public class Exhibition extends Event{
}
