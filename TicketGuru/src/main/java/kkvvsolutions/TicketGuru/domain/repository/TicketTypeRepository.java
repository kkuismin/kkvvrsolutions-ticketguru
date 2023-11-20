package kkvvsolutions.TicketGuru.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kkvvsolutions.TicketGuru.domain.TicketType;

public interface TicketTypeRepository extends CrudRepository<TicketType, Long> {
      List<TicketType> findByTicketName(String ticketName);
}
