package com.ironhack.lab_java_jpa.demo.event_system;

import com.ironhack.lab_java_jpa.enums.event_system.GuestStatus;
import com.ironhack.lab_java_jpa.model.event_system.Conference;
import com.ironhack.lab_java_jpa.model.event_system.Event;
import com.ironhack.lab_java_jpa.model.event_system.Exhibition;
import com.ironhack.lab_java_jpa.model.event_system.Guest;
import com.ironhack.lab_java_jpa.model.event_system.Speaker;
import com.ironhack.lab_java_jpa.repository.event_repository.EventRepository;
import com.ironhack.lab_java_jpa.repository.event_repository.GuestRepository;
import com.ironhack.lab_java_jpa.repository.event_repository.SpeakerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class DataLoader_EventSystem implements CommandLineRunner {

    private final EventRepository eventRepository;
    private final GuestRepository guestRepository;
    private final SpeakerRepository speakerRepository;

    public DataLoader_EventSystem(EventRepository eventRepository, GuestRepository guestRepository, SpeakerRepository speakerRepository) {
        this.eventRepository = eventRepository;
        this.guestRepository = guestRepository;
        this.speakerRepository = speakerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadEventData();
    }

    private void loadEventData() {
        // Crear eventos base (Event padre)
        Event concert = new Event(null, "Concert", LocalDate.of(2019, 5, 31), 4, "España", new ArrayList<>());

        // Conference es subclase - hereda de Event y tiene speakers
        Conference conference = new Conference();
        conference.setTitle("Tech Conference");
        conference.setDate(LocalDate.of(2019, 6, 15));
        conference.setDuration(2);
        conference.setLocation("Madrid");
        conference.setGuests(new ArrayList<>());
        conference.setSpeakers(new ArrayList<>());

        // Exhibition es subclase
        Exhibition exhibition = new Exhibition();
        exhibition.setTitle("Art Exhibition");
        exhibition.setDate(LocalDate.of(2019, 7, 20));
        exhibition.setDuration(3);
        exhibition.setLocation("Barcelona");
        exhibition.setGuests(new ArrayList<>());

        // Guardar eventos primero
        eventRepository.saveAll(Arrays.asList(concert, conference, exhibition));

        // Crear guests y asociarlos a eventos
        Guest guest1 = new Guest(null, "Ana García", GuestStatus.ATTENDING, concert);
        Guest guest2 = new Guest(null, "Carlos López", GuestStatus.NOT_ATTENDING, concert);
        Guest guest3 = new Guest(null, "María Ruiz", GuestStatus.ATTENDING, conference);
        Guest guest4 = new Guest(null, "Juan Martínez", GuestStatus.NO_RESPONSE, exhibition);

        // Añadir guests a las listas de eventos (bidireccional)
        concert.getGuests().addAll(Arrays.asList(guest1, guest2));
        conference.getGuests().add(guest3);
        exhibition.getGuests().add(guest4);

        // Guardar guests
        guestRepository.saveAll(Arrays.asList(guest1, guest2, guest3, guest4));

        // Crear speakers para la conferencia
        Speaker speaker1 = new Speaker(null, "Dr. Elena Torres", 45, conference);
        Speaker speaker2 = new Speaker(null, "Ing. Pedro Sánchez", 30, conference);

        // Añadir speakers a la conferencia
        conference.getSpeakers().addAll(Arrays.asList(speaker1, speaker2));

        // Guardar speakers
        speakerRepository.saveAll(Arrays.asList(speaker1, speaker2));
    }
}