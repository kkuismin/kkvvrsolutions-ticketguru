package kkvvsolutions.TicketGuru.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kkvvsolutions.TicketGuru.domain.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
  List<Event> findByName(String name);
  List<Event> findByVenueName(String string);
}
