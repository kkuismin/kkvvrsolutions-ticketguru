package kkvvsolutions.TicketGuru.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kkvvsolutions.TicketGuru.domain.TicketType;
import kkvvsolutions.TicketGuru.domain.TicketTypeRepository;

@RestController
@RequestMapping("/api")
public class RestTicketTypeController {

	@Autowired
	private TicketTypeRepository repository;

	@GetMapping("/tickettypes")
	public ResponseEntity<List<TicketType>> getAllTicketTypes() {

		try {
			List<TicketType> ticketTypes = new ArrayList<TicketType>();
			repository.findAll().forEach(ticketTypes::add);

			if (ticketTypes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(ticketTypes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tickettypes/{id}")
	public ResponseEntity<TicketType> getTicketTypeById(@PathVariable("id") Long typeId) {

		Optional<TicketType> ticketTypeData = repository.findById(typeId);

		if (ticketTypeData.isPresent()) {
			return new ResponseEntity<>(ticketTypeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/tickettypes")
	public ResponseEntity<TicketType> createTicketType(@RequestBody TicketType ticketType) {

		try {
			TicketType _ticketType = repository
					.save(new TicketType(ticketType.getPrice(), ticketType.getCustomerType(),
							ticketType.getDescription()));
			return new ResponseEntity<>(_ticketType, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tickettypes/{id}")
	public ResponseEntity<TicketType> updateTicketType(@PathVariable("id") Long typeId,
			@RequestBody TicketType ticketType) {

		Optional<TicketType> ticketTypeData = repository.findById(typeId);

		if (ticketTypeData.isPresent()) {
			TicketType _ticketType = ticketTypeData.get();
			_ticketType.setPrice(ticketType.getPrice());
			_ticketType.setCustomerType(ticketType.getCustomerType());
			_ticketType.setDescription(ticketType.getDescription());

			return new ResponseEntity<>(repository.save(_ticketType), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tickettypes")
	public ResponseEntity<HttpStatus> deleteAllTicketTypes() {

		try {
			repository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tickettypes/{id}")
	public ResponseEntity<HttpStatus> deleteTicketType(@PathVariable("id") Long typeId) {

		try {
			repository.deleteById(typeId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}