package kkvvsolutions.TicketGuru.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kkvvsolutions.TicketGuru.domain.Venue;

public interface VenueRepository extends CrudRepository<Venue, Long> {
      List<Venue> findByName(String name);
}
