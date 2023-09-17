package kkvvsolutions.TicketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kkvvsolutions.TicketGuru.domain.TicketType;
import kkvvsolutions.TicketGuru.repository.TicketTypeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ticketTypes")
public class TicketTypeController {

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    @GetMapping
    public List<TicketType> getAllTicketTypes() {
        return ticketTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketType> getTicketTypeById(@PathVariable Long id) {
        Optional<TicketType> ticketType = ticketTypeRepository.findById(id);
        if (ticketType.isPresent()) {
            return ResponseEntity.ok(ticketType.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public TicketType createTicketType(@RequestBody TicketType ticketType) {
        return ticketTypeRepository.save(ticketType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketType> updateTicketType(@PathVariable Long id, @RequestBody TicketType newTicketType) {
        Optional<TicketType> existingTicketType = ticketTypeRepository.findById(id);
        if (existingTicketType.isPresent()) {
            TicketType ticketType = existingTicketType.get();
            ticketType.setPrice(newTicketType.getPrice());
            ticketType.setCustomerType(newTicketType.getCustomerType());
            ticketType.setDescription(newTicketType.getDescription());
            ticketTypeRepository.save(ticketType);
            return ResponseEntity.ok(ticketType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketType(@PathVariable Long id) {
        if (ticketTypeRepository.existsById(id)) {
            ticketTypeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
