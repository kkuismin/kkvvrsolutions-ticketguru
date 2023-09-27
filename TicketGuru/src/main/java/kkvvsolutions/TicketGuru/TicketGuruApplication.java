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

@SpringBootApplication
public class TicketGuruApplication {
	
	private static final Logger log = LoggerFactory.getLogger(TicketGuruApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner eventDemo(EventRepository erepository, TicketRepository trepository, SaleEventRepository srepository) {
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
		};
		
	}
}
