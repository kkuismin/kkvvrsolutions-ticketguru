package kkvvsolutions.TicketGuru.domain.repository;

import org.springframework.data.repository.CrudRepository;

import kkvvsolutions.TicketGuru.domain.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

	AppUser findByUsername(String username);

}
