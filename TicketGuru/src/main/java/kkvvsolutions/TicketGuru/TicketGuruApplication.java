package kkvvsolutions.TicketGuru;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kkvvsolutions.TicketGuru.domain.Event;
import kkvvsolutions.TicketGuru.domain.SaleEvent;
import kkvvsolutions.TicketGuru.domain.Ticket;
import kkvvsolutions.TicketGuru.domain.TicketType;
import kkvvsolutions.TicketGuru.domain.Venue;
import kkvvsolutions.TicketGuru.domain.repository.EventRepository;
import kkvvsolutions.TicketGuru.domain.repository.SaleEventRepository;
import kkvvsolutions.TicketGuru.domain.repository.TicketRepository;
import kkvvsolutions.TicketGuru.domain.repository.TicketTypeRepository;
import kkvvsolutions.TicketGuru.domain.repository.VenueRepository;

@SpringBootApplication
public class TicketGuruApplication {

	private static final Logger log = LoggerFactory.getLogger(TicketGuruApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);
	}

	@Bean
	public CommandLineRunner eventDemo(EventRepository erepository, TicketRepository trepository,
			SaleEventRepository srepository, TicketTypeRepository ttrepository, VenueRepository vrepository) {
		return (args) -> {

			// Create a Venue
			Venue venue = new Venue("Stadium", "123 Street", "City", 5000);
			vrepository.save(venue);

			// Create an Event and link it to the Venue
			Event event = new Event("Konsertti", "20-10-2023", "19:30");
			event.setVenue(venue);
			erepository.save(event);

			// Create a TicketType and link it to the Event
			TicketType ticketType = new TicketType(15.00, "Opiskelija", "Alennus opiskelijoille");
			TicketType ticketType2 = new TicketType(10.00, "Työtön", "Alennus työttömille");

			ticketType.setEvent(event);
			ticketType2.setEvent(event);

			ttrepository.save(ticketType);
			ttrepository.save(ticketType2);

			// Create SaleEvent
			SaleEvent saleEvent = new SaleEvent(LocalDate.now(), LocalTime.now(), 30.00);
			srepository.save(saleEvent); // Save SaleEvent first to generate an ID

			// Create Tickets
			Ticket ticket1 = new Ticket(event, ticketType, "123456", saleEvent);
			Ticket ticket2 = new Ticket(event, ticketType2, "654321", saleEvent);

			// Save Tickets
			trepository.save(ticket1);
			trepository.save(ticket2);

			// Log information
			log.info("SaleEvent: " + saleEvent.toString());

		};
	}

}
