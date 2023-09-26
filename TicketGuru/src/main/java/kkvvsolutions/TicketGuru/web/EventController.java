package kkvvsolutions.TicketGuru;

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

import kkvvsolutions.TicketGuru.domain.Event;
import kkvvsolutions.TicketGuru.domain.EventRepository;

@RestController
@RequestMapping("/api")
public class EventController {
	
	@Autowired
	private EventRepository repository;
	
	@GetMapping("/events")
	public ResponseEntity<List<Event>> getAllEvents() {
		
		try {
			List<Event> events = new ArrayList<Event>();
			repository.findAll().forEach(events::add);
			
			if (events.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(events, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/events/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable("id") Long event_id) {
		
		Optional<Event> eventData = repository.findById(event_id);
		
		if (eventData.isPresent()) {
			return new ResponseEntity<>(eventData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/events")
	public ResponseEntity<Event> createEvent(@RequestBody Event event) {
		
		try {
			Event _event = repository
					.save(new Event(event.getName(), event.getDate(), event.getTime()));
			return new ResponseEntity<>(_event, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/events/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable("id") Long event_id, @RequestBody Event event) {
		
		Optional<Event> eventData = repository.findById(event_id);
		
		if (eventData.isPresent()) {
			Event _event = eventData.get();
			_event.setName(event.getName());
			_event.setDate(event.getDate());
			_event.setTime(event.getTime());
			
			return new ResponseEntity<>(repository.save(_event), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/events")
	public ResponseEntity<HttpStatus> deleteAllEvents() {
		
		try {
			repository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/events/{id}")
	public ResponseEntity<HttpStatus> deleteEvent(@PathVariable("id") Long event_id) {
		
		try {
			repository.deleteById(event_id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}