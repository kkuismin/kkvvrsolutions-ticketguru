package kkvvsolutions.TicketGuru.domain.repository;

import org.springframework.data.repository.CrudRepository;

import kkvvsolutions.TicketGuru.domain.TicketType;

public interface TicketTypeRepository extends CrudRepository<TicketType, Long> {

}