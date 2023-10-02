package kkvvsolutions.TicketGuru.domain.repository;

import org.springframework.data.repository.CrudRepository;

import kkvvsolutions.TicketGuru.domain.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

}