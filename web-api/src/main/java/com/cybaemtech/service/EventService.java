package com.cybaemtech.service;

import com.cybaemtech.model.Event;
import com.cybaemtech.model.User;
import com.cybaemtech.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService
{
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    public List<Event> getEventsByUser(Long userId)
    {
        return eventRepository.findByUserId(userId);
    }

    public Event createEvent(Event event)
    {
        copy(event);
        sendEventEmail(event);
        return eventRepository.save(event);
    }

    private void sendEventEmail(Event event)
    {
        //TODO : WRITE EMAIL BODY

        emailService.sendEmail("check in","shubhw88@gmail.com", "Event added to calendar");
    }

    private void copy(Event event)
    {
        User user = userService.getUserById(event.getUserId());
        event.setUser(user);
    }

    public Optional<Event> getEventById(Long id)
    {
        return eventRepository.findById(id);
    }

    public Event updateEvent(Long id, Event updatedEvent)
    {
        copy(updatedEvent);

        return eventRepository.findById(id).map(event ->
        {
            event.setTitle(updatedEvent.getTitle());
            event.setFromTimestamp(updatedEvent.getFromTimestamp());
            event.setToTimestamp(updatedEvent.getToTimestamp());
            event.setDescription(updatedEvent.getDescription());
            event.setColor(updatedEvent.getColor());
            return eventRepository.save(event);
        }).orElse(null);
    }

    public void deleteEvent(Long id)
    {
        eventRepository.deleteById(id);
    }
}
