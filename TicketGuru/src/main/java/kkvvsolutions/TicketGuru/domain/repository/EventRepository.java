package kkvvsolutions.TicketGuru.domain.repository;

import org.springframework.data.repository.CrudRepository;

import kkvvsolutions.TicketGuru.domain.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}