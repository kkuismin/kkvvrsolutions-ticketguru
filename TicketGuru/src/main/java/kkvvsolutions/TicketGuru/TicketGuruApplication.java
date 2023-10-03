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

			List<TicketType> ticketTypes = new ArrayList<>();
			ticketTypes.add(ticketType);
			ticketTypes.add(ticketType2);

			// Link TicketType to Event
			for (TicketType tt : ticketTypes) {
				tt.setEvent(event);
				ttrepository.save(tt);
			}

			event.setTicketTypes(ticketTypes);
			erepository.save(event);

			// Create Tickets
			Ticket ticket1 = new Ticket("123456", "Opiskelija");
			Ticket ticket2 = new Ticket("654321", "Työtön");

			// Link Tickets to Event
			ticket1.setEvent(event);
			ticket2.setEvent(event);

			List<Ticket> tickets = new ArrayList<>();
			tickets.add(ticket1);
			tickets.add(ticket2);

			for (Ticket t : tickets) {
				t.setEvent(event);
				trepository.save(t);
			}

			event.setTickets(tickets);
			erepository.save(event);

			// Create SaleEvent
			SaleEvent saleEvent = new SaleEvent(LocalDate.now(), LocalTime.now(), 30.00);

			// Link Tickets to SaleEvent
			for (Ticket t : tickets) {
				t.setSaleEvent(saleEvent);
			}

			// Save SaleEvent with the associated tickets
			srepository.save(saleEvent);

			// Save each ticket with the associated SaleEvent
			for (Ticket t : tickets) {
				trepository.save(t);
			}

			log.info("SaleEvent: " + saleEvent.toString());

		};
	}

}
