package kkvvsolutions.TicketGuru.domain.repository;

import org.springframework.data.repository.CrudRepository;

import kkvvsolutions.TicketGuru.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

}
