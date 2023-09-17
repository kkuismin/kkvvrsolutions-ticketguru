package kkvvsolutions.TicketGuru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kkvvsolutions.TicketGuru.domain.TicketType;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {

}