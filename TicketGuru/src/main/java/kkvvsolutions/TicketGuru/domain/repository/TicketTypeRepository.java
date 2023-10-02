package kkvvsolutions.TicketGuru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TicketTypeRepository extends CrudRepository<TicketType, Long> {
	List<TicketType> findAll();

	List<TicketType> findByEvent_EventId(Long eventId);
}