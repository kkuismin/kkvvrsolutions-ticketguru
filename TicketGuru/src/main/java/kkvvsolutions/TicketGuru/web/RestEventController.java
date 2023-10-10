package kkvvsolutions.TicketGuru.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kkvvsolutions.TicketGuru.domain.Event;
import kkvvsolutions.TicketGuru.domain.Venue;
import kkvvsolutions.TicketGuru.domain.repository.EventRepository;

@RestController
@RequestMapping("/api")
public class RestEventController {

	@Autowired
	private EventRepository erepository;

	// All Events
	@GetMapping("/events")
	public ResponseEntity<List<Event>> getAllEvents() {

		try {
			List<Event> events = new ArrayList<Event>();
			erepository.findAll().forEach(events::add);

			if (events.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT); // HTTP 204 No Content
			}

			return new ResponseEntity<>(events, HttpStatus.OK); // HTTP 200 OK
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // HTTP 400 Bad Request
		}

	}

	// Event by ID
	@GetMapping("/events/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable("id") Long eventId) {
		Optional<Event> eventData = erepository.findById(eventId);

		if (eventData.isPresent()) {
			return new ResponseEntity<>(eventData.get(), HttpStatus.OK); // HTTP 200 OK
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // HTTP 404 Not Found
		}
	}

	// Event by Venue
	@GetMapping("/events/{id}/venue")
	public ResponseEntity<Venue> getVenue(@PathVariable("id") Long eventId) {
		Optional<Event> eventData = erepository.findById(eventId);

		if (eventData.isPresent()) {
			Event event = eventData.get();
			if (event.getVenue() != null) {
				Venue venue = event.getVenue();
				return new ResponseEntity<>(venue, HttpStatus.OK); // HTTP 200 OK
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND); // HTTP 404 Not Found
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // HTTP 404 Not Found
		}
	}

	// Create new Event
	@PostMapping("/events")
	public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event) {

		try {
			Event _event = erepository.save(event);
			return new ResponseEntity<>(_event, HttpStatus.CREATED); // HTTP 201 OK
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // HTTP 400 Bad Request
		}
	}

	// Edit Event
	@PutMapping("/events/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable("id") Long eventId, @RequestBody Event event) {

		Optional<Event> eventData = erepository.findById(eventId);

		if (eventData.isPresent()) {
			Event _event = eventData.get();
			_event.setVenue(event.getVenue());
			_event.setName(event.getName());
			_event.setDate(event.getDate());
			_event.setTime(event.getTime());

			return new ResponseEntity<>(erepository.save(_event), HttpStatus.OK); // HTTP 200 OK
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // HTTP 404 Not Found
		}
	}

	// Delete Event by ID
	@DeleteMapping("/events/{id}")
	public ResponseEntity<HttpStatus> deleteEvent(@PathVariable("id") Long eventId) {

		try {
			erepository.deleteById(eventId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // HTTP 204 No content
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // HTTP 404 Not Found
		}
	}

}
