package kkvvsolutions.TicketGuru.web;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

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
import kkvvsolutions.TicketGuru.domain.TicketType;
import kkvvsolutions.TicketGuru.domain.repository.TicketTypeRepository;

@RestController
@RequestMapping("/api")
public class RestTicketTypeController {

	@Autowired
	private TicketTypeRepository ticketTypeRepository;

	// Endpoint to retrieve all ticket types
	@GetMapping("/tickettypes")
	public ResponseEntity<List<TicketType>> getAllTicketTypes() {
		try {
			List<TicketType> ticketTypes = new ArrayList<TicketType>();
			ticketTypeRepository.findAll().forEach(ticketTypes::add);
			if (ticketTypes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(ticketTypes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// Endpoint to retrieve a ticket type by its ID
	@GetMapping("/tickettypes/{id}")
	public ResponseEntity<TicketType> getTicketTypeById(@PathVariable("id") Long typeId) {
		Optional<TicketType> ticketTypeData = ticketTypeRepository.findById(typeId);
		if (ticketTypeData.isPresent()) {
			return new ResponseEntity<>(ticketTypeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to retrieve the event of a ticket type by its ID
	@GetMapping("/tickettypes/{id}/event")
	public ResponseEntity<Event> getEvent(@PathVariable("id") Long eventId) {
		Optional<TicketType> ticketTypeData = ticketTypeRepository.findById(eventId);
		if (ticketTypeData.isPresent()) {
			TicketType ticketType = ticketTypeData.get();
			if (ticketType.getEvent() != null) {
				Event event = ticketType.getEvent();
				return new ResponseEntity<>(event, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to create a new ticket type
	@PostMapping("/tickettypes")
	public ResponseEntity<TicketType> createTicketType(@Valid @RequestBody TicketType ticketType) {

		try {
			TicketType _ticketType = ticketTypeRepository.save(ticketType);
			return new ResponseEntity<>(_ticketType, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// Endpoint to update an existing ticket type by its ID
	@PutMapping("/tickettypes/{id}")
	public ResponseEntity<TicketType> updateTicketType(@PathVariable("id") Long typeId,
			@Valid @RequestBody TicketType ticketType) {
		Optional<TicketType> ticketTypeData = ticketTypeRepository.findById(typeId);
		if (ticketTypeData.isPresent()) {
			TicketType _ticketType = ticketTypeData.get();
			_ticketType.setPrice(ticketType.getPrice());
			_ticketType.setTicketName(ticketType.getTicketName());
			_ticketType.setDescription(ticketType.getDescription());

			return new ResponseEntity<>(ticketTypeRepository.save(_ticketType), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to delete all ticket types
	@DeleteMapping("/tickettypes")
	public ResponseEntity<HttpStatus> deleteAllTicketTypes() {

		try {
			ticketTypeRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to delete a ticket type by its ID
	@DeleteMapping("/tickettypes/{id}")
	public ResponseEntity<HttpStatus> deleteTicketType(@PathVariable("id") Long typeId) {

		try {
			ticketTypeRepository.deleteById(typeId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}