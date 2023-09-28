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
import kkvvsolutions.TicketGuru.domain.EventRepository;
import kkvvsolutions.TicketGuru.domain.SaleEvent;
import kkvvsolutions.TicketGuru.domain.SaleEventRepository;
import kkvvsolutions.TicketGuru.domain.Ticket;
import kkvvsolutions.TicketGuru.domain.TicketRepository;
import kkvvsolutions.TicketGuru.domain.TicketType;
import kkvvsolutions.TicketGuru.domain.TicketTypeRepository;
import kkvvsolutions.TicketGuru.domain.Venue;
import kkvvsolutions.TicketGuru.domain.VenueRepository;

@SpringBootApplication
public class TicketGuruApplication {
	
	private static final Logger log = LoggerFactory.getLogger(TicketGuruApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner eventDemo(EventRepository erepository, TicketRepository trepository, SaleEventRepository srepository, TicketTypeRepository ttrepository, VenueRepository vrepository) {
	    return (args) -> {
	        
	        // Create a Venue
	        Venue venue = new Venue("Stadium", "123 Street", "City", 5000);
	        vrepository.save(venue);
	       

	        // Create an Event and link it to the Venue
	        Event event = new Event("Konsertti", "20-10-2023", "19:30");
	        event.setVenue(venue);
	        erepository.save(event);

	        // Create a TicketType and link it to the Event
	        TicketType ticketType = new TicketType(15.00, "Aikuinen", "Aikuisen lippu");
	        TicketType ticketType2 = new TicketType(15.00, "Aikuinen", "Aikuisen lippu");

	        List<TicketType> tickets = new ArrayList<>();
	        tickets.add(ticketType);
	        tickets.add(ticketType2);

	        
	        log.info("adada" + tickets);
	        
	        ttrepository.save(ticketType); // Save TicketType
	        event.setTicketTypes(tickets); // Link TicketType to Event
	        
	        erepository.save(event);

	        log.info("event tickettypes " + event.toString());
	    };
	}


}