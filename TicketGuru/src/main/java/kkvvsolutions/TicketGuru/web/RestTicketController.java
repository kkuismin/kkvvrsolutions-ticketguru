package kkvvsolutions.TicketGuru.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kkvvsolutions.TicketGuru.domain.Event;
import kkvvsolutions.TicketGuru.domain.SaleEvent;
import kkvvsolutions.TicketGuru.domain.Ticket;
import kkvvsolutions.TicketGuru.domain.TicketType;
import kkvvsolutions.TicketGuru.domain.repository.TicketRepository;

@RestController
@RequestMapping("/api")
public class RestTicketController {

	@Autowired
	private TicketRepository trepository;

	// Endpoint to retrieve all tickets
	@GetMapping("/tickets")
	public ResponseEntity<List<Ticket>> getAllTickets() {

		try {
			List<Ticket> tickets = new ArrayList<Ticket>();
			trepository.findAll().forEach(tickets::add);

			if (tickets.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tickets, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	// Endpoint to retrieve a ticket by its ID
	@GetMapping("/tickets/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Long ticketId) {
		Optional<Ticket> ticketData = trepository.findById(ticketId);

		if (ticketData.isPresent()) {
			return new ResponseEntity<>(ticketData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	// Endpoint to get the TicketType of a ticket
	@GetMapping("/tickets/{id}/tickettype")
	public ResponseEntity<TicketType> getTicketType(@PathVariable("id") Long ticketId) {
		Optional<Ticket> ticketData = trepository.findById(ticketId);

		if (ticketData.isPresent()) {
			Ticket ticket = ticketData.get();
			if (ticket.getTicketType() != null) {
				TicketType ticketType = ticket.getTicketType();
				return new ResponseEntity<>(ticketType, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to get the Event associated with a ticket
	@GetMapping("/tickets/{id}/event")
	public ResponseEntity<Event> getEvent(@PathVariable("id") Long eventId) {
		Optional<Ticket> ticketData = trepository.findById(eventId);

		if (ticketData.isPresent()) {
			Ticket ticket = ticketData.get();
			if (ticket.getEvent() != null) {
				Event event = ticket.getEvent();
				return new ResponseEntity<>(event, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to get the SaleEvent associated with a ticket
	@GetMapping("/tickets/{id}/sales")
	public ResponseEntity<SaleEvent> getSaleEvent(@PathVariable("id") Long saleEventId) {
		Optional<Ticket> ticketData = trepository.findById(saleEventId);

		if (ticketData.isPresent()) {
			Ticket ticket = ticketData.get();
			if (ticket.getSaleEvent() != null) {
				SaleEvent saleEvent = ticket.getSaleEvent();
				return new ResponseEntity<>(saleEvent, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to create a new ticket
	@PostMapping("/tickets")
	public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket) {

		try {
			Ticket _ticket = trepository.save(ticket);
			return new ResponseEntity<>(_ticket, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// Endpoint to update a ticket by its ID
	@PutMapping("/tickets/{id}")
	public ResponseEntity<Ticket> updateTicket(@PathVariable("id") Long ticketId, @Valid @RequestBody Ticket ticket) {

		Optional<Ticket> ticketData = trepository.findById(ticketId);

		if (ticketData.isPresent()) {
			Ticket _ticket = ticketData.get();
			_ticket.setBarcode(ticket.getBarcode());
			_ticket.setTicketType(ticket.getTicketType());

			return new ResponseEntity<>(trepository.save(_ticket), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to delete a ticket by its ID
	@DeleteMapping("/tickets/{id}")
	public ResponseEntity<HttpStatus> deleteTicket(@PathVariable("id") Long ticketId) {

		try {
			trepository.deleteById(ticketId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to get a ticket by its barcode
	@GetMapping("/tickets/barcode/{barcode}")
	public ResponseEntity<Ticket> getTicketByBarcode(@PathVariable String barcode) {
		Optional<Ticket> ticket = trepository.findByBarcode(barcode);
		if (ticket.isPresent()) {
			return new ResponseEntity<>(ticket.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to update the checked status of a ticket
	@PatchMapping("/tickets/barcode/{barcode}/checked")
	public ResponseEntity<Ticket> updateTicketCheckedStatus(@PathVariable("barcode") String barcode,
			@RequestBody Map<String, Boolean> updates) {
		Optional<Ticket> ticketData = trepository.findByBarcode(barcode);

		if (ticketData.isPresent()) {
			Ticket ticket = ticketData.get();
			if (updates.containsKey("isChecked")) {
				ticket.setIsChecked(updates.get("isChecked"));
				trepository.save(ticket);
				return new ResponseEntity<>(ticket, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
