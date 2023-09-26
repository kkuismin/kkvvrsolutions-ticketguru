package kkvvsolutions.TicketGuru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kkvvsolutions.TicketGuru.domain.EventRepository;
import kkvvsolutions.TicketGuru.domain.SaleEvent;
import kkvvsolutions.TicketGuru.domain.SaleEventRepository;
import kkvvsolutions.TicketGuru.domain.Event;

@SpringBootApplication
public class TicketGuruApplication {
	
	private static final Logger log = LoggerFactory.getLogger(TicketGuruApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner eventDemo(EventRepository repository) {
		return (args) -> {
			
			log.info("list a couple of events");
			repository.save(new Event("Konsertti", "20-10-2023", "19:30"));
			repository.save(new Event("Lätkämatsi", "11-11-2023", "18:30"));
			repository.save(new Event("Baletti", "12-12-2023", "20:00"));
			
			for (Event event : repository.findAll()) {
				log.info(event.toString());
			}
		};
	}
	
	@Bean
	public CommandLineRunner saleEventDemo(SaleEventRepository repository) {
		return (args) -> {
			
			log.info("list a couple of sales");
			repository.save(new SaleEvent());
			repository.save(new SaleEvent());
			repository.save(new SaleEvent());
			
			for (SaleEvent saleEvent : repository.findAll()) {
				log.info(saleEvent.toString());
			}
		};
	}
}
