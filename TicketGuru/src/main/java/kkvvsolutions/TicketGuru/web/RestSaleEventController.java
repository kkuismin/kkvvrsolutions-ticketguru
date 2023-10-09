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

import jakarta.transaction.Transactional;
import kkvvsolutions.TicketGuru.domain.SaleEvent;
import kkvvsolutions.TicketGuru.domain.Ticket;
import kkvvsolutions.TicketGuru.domain.repository.SaleEventRepository;
import kkvvsolutions.TicketGuru.domain.repository.TicketRepository;

@RestController
@RequestMapping("/api")
public class RestSaleEventController {

	@Autowired
	SaleEventRepository saleEventRepository;

	@Autowired
	TicketRepository ticketRepository;

	@GetMapping("/sales")
	public ResponseEntity<List<SaleEvent>> getAllSaleEvents() {

		try {
			List<SaleEvent> sales = new ArrayList<SaleEvent>();
			saleEventRepository.findAll().forEach(sales::add);

			if (sales.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(sales, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/sales/{id}")
	public ResponseEntity<SaleEvent> getSaleEventById(@PathVariable("id") Long saleEvent_id) {

		Optional<SaleEvent> salesData = saleEventRepository.findById(saleEvent_id);

		if (salesData.isPresent()) {
			return new ResponseEntity<>(salesData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Transactional
	@PostMapping("/sales")
	public ResponseEntity<SaleEvent> createSaleEvent(@RequestBody SaleEvent saleEvent) {
		try {
			for (Ticket ticket : saleEvent.getTicketList()) {
				ticket.setSaleEvent(saleEvent);
			}

			SaleEvent _saleEvent = saleEventRepository.save(saleEvent);

			return new ResponseEntity<>(_saleEvent, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/sales/{id}")
	public ResponseEntity<SaleEvent> updateSaleEvent(@PathVariable("id") Long saleEvent_id,
			@RequestBody SaleEvent saleEvent) {

		Optional<SaleEvent> saleEventData = saleEventRepository.findById(saleEvent_id);

		if (saleEventData.isPresent()) {
			SaleEvent _saleEvent = saleEventData.get();
			_saleEvent.setSaleDate(saleEvent.getSaleDate());
			_saleEvent.setSaleTime(saleEvent.getSaleTime());
			_saleEvent.setAmount(saleEvent.getAmount());

			return new ResponseEntity<>(saleEventRepository.save(_saleEvent), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/sales")
	public ResponseEntity<HttpStatus> deleteAllSaleEvents() {

		try {
			saleEventRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/sales/{id}")
	public ResponseEntity<HttpStatus> deleteSaleEvent(@PathVariable("id") Long saleEvent_id) {

		try {
			saleEventRepository.deleteById(saleEvent_id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
