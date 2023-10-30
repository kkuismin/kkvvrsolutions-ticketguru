package kkvvsolutions.TicketGuru;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kkvvsolutions.TicketGuru.domain.Event;

import kkvvsolutions.TicketGuru.domain.TicketType;
import kkvvsolutions.TicketGuru.domain.UserRole;
import kkvvsolutions.TicketGuru.domain.AppUser;
import kkvvsolutions.TicketGuru.domain.Venue;
import kkvvsolutions.TicketGuru.domain.repository.EventRepository;
import kkvvsolutions.TicketGuru.domain.repository.SaleEventRepository;
import kkvvsolutions.TicketGuru.domain.repository.TicketRepository;
import kkvvsolutions.TicketGuru.domain.repository.TicketTypeRepository;
import kkvvsolutions.TicketGuru.domain.repository.AppUserRepository;
import kkvvsolutions.TicketGuru.domain.repository.VenueRepository;

@SpringBootApplication
public class TicketGuruApplication {

	private static final Logger log = LoggerFactory.getLogger(TicketGuruApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);
	}

	@Bean
	public CommandLineRunner initializeDatabase(VenueRepository venueRepository,
			EventRepository eventRepository,
			TicketTypeRepository ticketTypeRepository, SaleEventRepository saleEventRepository,
			TicketRepository ticketRepository, AppUserRepository userRepository) {
		return args -> {
			// 1. Create and Save Venue
			// Venue venue = new Venue("Stadium", "123 Street", "City", 5000);
			// venue = venueRepository.save(venue);

			// 2. Create, Associate with Venue, and Save Event
			// Event event = new Event(venue, "Concert", LocalDate.of(2023, 10, 20),
			//		LocalTime.of(19, 30));
			//event = eventRepository.save(event);

			// 3. Create, Associate with Event, and Save TicketTypes
			// TicketType studentTicketType = new TicketType(15.00, "Student", "Discount for students", event);
			// TicketType regularTicketType = new TicketType(25.00, "Regular", "Standard price", event);

			// Save TicketTypes to the database
			// event.getTicketTypes().addAll(Arrays.asList(studentTicketType,
			//		regularTicketType));
			// ticketTypeRepository.saveAll(Arrays.asList(studentTicketType,
			//		regularTicketType));

			//eventRepository.save(event);

			//AppUser user1 = new AppUser("admin", "$2a$10$bRnDm/nAWqHORRh.hA9R1Oqpm6pDQFeLCVvhxgvhONe42qj8bImyi",
			//		UserRole.ADMIN);
			// userRepository.save(user1);

		};
	};
}
