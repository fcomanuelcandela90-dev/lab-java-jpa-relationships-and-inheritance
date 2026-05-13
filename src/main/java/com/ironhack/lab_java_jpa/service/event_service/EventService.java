package com.ironhack.lab_java_jpa.service.event_service;

import com.ironhack.lab_java_jpa.enums.event_system.GuestStatus;
import com.ironhack.lab_java_jpa.model.event_system.*;
import com.ironhack.lab_java_jpa.repository.event_repository.EventRepository;
import com.ironhack.lab_java_jpa.repository.event_repository.GuestRepository;
import com.ironhack.lab_java_jpa.repository.event_repository.SpeakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final GuestRepository guestRepository;
    private final SpeakerRepository speakerRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Optional<Event> updateEvent(Long id, Event event) {
        Optional<Event> existing = eventRepository.findById(id);
        if (existing.isPresent()) {
            Event e = existing.get();
            e.setTitle(event.getTitle());
            e.setDate(event.getDate());
            e.setDuration(event.getDuration());
            e.setLocation(event.getLocation());
            return Optional.of(eventRepository.save(e));
        }
        return Optional.empty();
    }

    public Optional<Event> patchEvent(Long id, Event event) {
        Optional<Event> existing = eventRepository.findById(id);
        if (existing.isPresent()) {
            Event e = existing.get();
            if (event.getTitle() != null) e.setTitle(event.getTitle());
            if (event.getDate() != null) e.setDate(event.getDate());
            if (event.getDuration() != null) e.setDuration(event.getDuration());
            if (event.getLocation() != null) e.setLocation(event.getLocation());
            return Optional.of(eventRepository.save(e));
        }
        return Optional.empty();
    }

    public boolean deleteEvent(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Conference> getAllConferences() {
        return eventRepository.findAll().stream()
                .filter(e -> e instanceof Conference)
                .map(e -> (Conference) e)
                .toList();
    }

    public Optional<Conference> getConferenceById(Long id) {
        return eventRepository.findById(id)
                .filter(e -> e instanceof Conference)
                .map(e -> (Conference) e);
    }

    public Conference createConference(Conference conference) {
        return eventRepository.save(conference);
    }

    public Optional<Conference> updateConference(Long id, Conference conference) {
        Optional<Conference> existing = getConferenceById(id);
        if (existing.isPresent()) {
            Conference c = existing.get();
            c.setTitle(conference.getTitle());
            c.setDate(conference.getDate());
            c.setDuration(conference.getDuration());
            c.setLocation(conference.getLocation());
            c.setSpeakers(conference.getSpeakers());
            return Optional.of((Conference) eventRepository.save(c));
        }
        return Optional.empty();
    }

    public Optional<Conference> patchConference(Long id, Conference conference) {
        Optional<Conference> existing = getConferenceById(id);
        if (existing.isPresent()) {
            Conference c = existing.get();
            if (conference.getTitle() != null) c.setTitle(conference.getTitle());
            if (conference.getDate() != null) c.setDate(conference.getDate());
            if (conference.getDuration() != null) c.setDuration(conference.getDuration());
            if (conference.getLocation() != null) c.setLocation(conference.getLocation());
            if (conference.getSpeakers() != null) c.setSpeakers(conference.getSpeakers());
            return Optional.of((Conference) eventRepository.save(c));
        }
        return Optional.empty();
    }

    public boolean deleteConference(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Exhibition> getAllExhibitions() {
        return eventRepository.findAll().stream()
                .filter(e -> e instanceof Exhibition)
                .map(e -> (Exhibition) e)
                .toList();
    }

    public Optional<Exhibition> getExhibitionById(Long id) {
        return eventRepository.findById(id)
                .filter(e -> e instanceof Exhibition)
                .map(e -> (Exhibition) e);
    }

    public Exhibition createExhibition(Exhibition exhibition) {
        return eventRepository.save(exhibition);
    }

    public Optional<Exhibition> updateExhibition(Long id, Exhibition exhibition) {
        Optional<Exhibition> existing = getExhibitionById(id);
        if (existing.isPresent()) {
            Exhibition e = existing.get();
            e.setTitle(exhibition.getTitle());
            e.setDate(exhibition.getDate());
            e.setDuration(exhibition.getDuration());
            e.setLocation(exhibition.getLocation());
            return Optional.of((Exhibition) eventRepository.save(e));
        }
        return Optional.empty();
    }

    public Optional<Exhibition> patchExhibition(Long id, Exhibition exhibition) {
        Optional<Exhibition> existing = getExhibitionById(id);
        if (existing.isPresent()) {
            Exhibition e = existing.get();
            if (exhibition.getTitle() != null) e.setTitle(exhibition.getTitle());
            if (exhibition.getDate() != null) e.setDate(exhibition.getDate());
            if (exhibition.getDuration() != null) e.setDuration(exhibition.getDuration());
            if (exhibition.getLocation() != null) e.setLocation(exhibition.getLocation());
            return Optional.of((Exhibition) eventRepository.save(e));
        }
        return Optional.empty();
    }

    public boolean deleteExhibition(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Optional<Guest> getGuestById(Long id) {
        return guestRepository.findById(id);
    }

    public List<Guest> getGuestsByStatus(GuestStatus status) {
        return guestRepository.findByStatus(status);
    }

    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Optional<Guest> updateGuest(Long id, Guest guest) {
        Optional<Guest> existing = guestRepository.findById(id);
        if (existing.isPresent()) {
            Guest g = existing.get();
            g.setName(guest.getName());
            g.setStatus(guest.getStatus());
            g.setEvent(guest.getEvent());
            return Optional.of(guestRepository.save(g));
        }
        return Optional.empty();
    }

    public Optional<Guest> patchGuest(Long id, Guest guest) {
        Optional<Guest> existing = guestRepository.findById(id);
        if (existing.isPresent()) {
            Guest g = existing.get();
            if (guest.getName() != null) g.setName(guest.getName());
            if (guest.getStatus() != null) g.setStatus(guest.getStatus());
            if (guest.getEvent() != null) g.setEvent(guest.getEvent());
            return Optional.of(guestRepository.save(g));
        }
        return Optional.empty();
    }

    public boolean deleteGuest(Long id) {
        if (guestRepository.existsById(id)) {
            guestRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Speaker> getAllSpeakers() {
        return speakerRepository.findAll();
    }

    public Optional<Speaker> getSpeakerById(Long id) {
        return speakerRepository.findById(id);
    }

    public Speaker createSpeaker(Speaker speaker) {
        return speakerRepository.save(speaker);
    }

    public Optional<Speaker> updateSpeaker(Long id, Speaker speaker) {
        Optional<Speaker> existing = speakerRepository.findById(id);
        if (existing.isPresent()) {
            Speaker s = existing.get();
            s.setName(speaker.getName());
            s.setPresentationDuration(speaker.getPresentationDuration());
            s.setConference(speaker.getConference());
            return Optional.of(speakerRepository.save(s));
        }
        return Optional.empty();
    }

    public Optional<Speaker> patchSpeaker(Long id, Speaker speaker) {
        Optional<Speaker> existing = speakerRepository.findById(id);
        if (existing.isPresent()) {
            Speaker s = existing.get();
            if (speaker.getName() != null) s.setName(speaker.getName());
            if (speaker.getPresentationDuration() != null) s.setPresentationDuration(speaker.getPresentationDuration());
            if (speaker.getConference() != null) s.setConference(speaker.getConference());
            return Optional.of(speakerRepository.save(s));
        }
        return Optional.empty();
    }

    public boolean deleteSpeaker(Long id) {
        if (speakerRepository.existsById(id)) {
            speakerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}