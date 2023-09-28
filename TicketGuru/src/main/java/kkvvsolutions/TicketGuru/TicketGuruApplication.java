package kkvvsolutions.TicketGuru;

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

@SpringBootApplication
public class TicketGuruApplication {
	
	private static final Logger log = LoggerFactory.getLogger(TicketGuruApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner eventDemo(EventRepository erepository, TicketRepository trepository, SaleEventRepository srepository, TicketTypeRepository ttrepository) {
		return (args) -> {
			
			log.info("list a couple of events");
			erepository.save(new Event("Konsertti", "20-10-2023", "19:30"));
			erepository.save(new Event("Lätkämatsi", "11-11-2023", "18:30"));
			erepository.save(new Event("Baletti", "12-12-2023", "20:00"));
			
			for (Event event : erepository.findAll()) {
				log.info(event.toString());
			}

				log.info("list a couple of sales");
			srepository.save(new SaleEvent());
			srepository.save(new SaleEvent());
			srepository.save(new SaleEvent());
			
			for (SaleEvent saleEvent : srepository.findAll()) {
				log.info(saleEvent.toString());
			}
			
			log.info("list a couple of tickets");
			trepository.save(new Ticket("121", "Aikuinen"));
			trepository.save(new Ticket("122", "Lapsi"));
			trepository.save(new Ticket("123", "Opiskelija"));
			
			for (Ticket ticket : trepository.findAll()) {
				log.info(ticket.toString());
			}
			
            log.info("list a couple of ticket types");
            ttrepository.save(new TicketType(15.00, "Aikuinen", "Aikuisen lippu"));
            ttrepository.save(new TicketType(7.50, "Lapsi", "Lapsen lippu alle 12v"));
            ttrepository.save(new TicketType(10.00, "Opiskelija", "Opiskelijan lippu voimassaolevalla opiskelijakortilla"));

            for (TicketType ticketType : ttrepository.findAll()) {
                log.info(ticketType.toString());
            }
            
            // Fetch an existing event
            Event concertEvent = erepository.findByName("Konsertti").orElse(null);
            if (concertEvent != null) {
                TicketType adultTicketType = new TicketType(15.00, "Aikuinen", "Aikuisen lippu");
                adultTicketType.setEvent(concertEvent);  // Link the ticket type to the event
                ttrepository.save(adultTicketType);

                TicketType childTicketType = new TicketType(7.50, "Lapsi", "Lapsen lippu alle 12v");
                childTicketType.setEvent(concertEvent);  // Link the ticket type to the event
                ttrepository.save(childTicketType);
            }

            for (TicketType ticketType : ttrepository.findAll()) {
                log.info(ticketType.toString());
            }
		};
		
	}
}
