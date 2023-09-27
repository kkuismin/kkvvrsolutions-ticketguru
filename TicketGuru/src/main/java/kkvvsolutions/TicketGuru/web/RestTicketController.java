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

import kkvvsolutions.TicketGuru.domain.Ticket;
import kkvvsolutions.TicketGuru.domain.TicketRepository;

@RestController
@RequestMapping("/api")
public class RestTicketController {
	
	@Autowired
	private TicketRepository repository;
	
	@GetMapping("/tickets")
	public ResponseEntity<List<Ticket>> getAllTickets() {
		
		try {
			List<Ticket> tickets = new ArrayList<Ticket>();
			repository.findAll().forEach(tickets::add);
			
			if (tickets.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/tickets/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Long ticket_id) {
		Optional<Ticket> ticketData = repository.findById(ticket_id);
		
		if (ticketData.isPresent()) {
			return new ResponseEntity<>(ticketData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/tickets")
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
		
		try {
			Ticket _ticket = repository.save(new Ticket(ticket.getBarcode(), ticket.getType()));
			return new ResponseEntity<>(_ticket, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/tickets/{id}")
	public ResponseEntity<Ticket> updateTicket(@PathVariable("id") Long ticket_id, @RequestBody Ticket ticket) {
		
		Optional<Ticket> ticketData = repository.findById(ticket_id);
		
		if (ticketData.isPresent()) {
			Ticket _ticket = ticketData.get();
			_ticket.setBarcode(ticket.getBarcode());
			_ticket.setType(ticket.getType());
			
			return new ResponseEntity<>(repository.save(_ticket), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/tickets/{id}")
	public ResponseEntity<HttpStatus> deleteTicket(@PathVariable("id") Long ticket_id) {
		
		try {
			repository.deleteById(ticket_id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
