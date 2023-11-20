package kkvvsolutions.TicketGuru;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kkvvsolutions.TicketGuru.domain.Venue;
import kkvvsolutions.TicketGuru.domain.repository.VenueRepository;
import kkvvsolutions.TicketGuru.domain.Event;
import kkvvsolutions.TicketGuru.domain.repository.EventRepository;
import kkvvsolutions.TicketGuru.domain.TicketType;
import kkvvsolutions.TicketGuru.domain.repository.TicketTypeRepository;

@SpringBootTest
class TicketGuruRepositoryTests {
    
	@Autowired
	VenueRepository vrepository;
	
	@Autowired
	EventRepository erepository;
	
	@Autowired
	TicketTypeRepository ttrepository;
	
    
    //Adding New Venue + Event Details into index.html (in addition to the existing one in database)
    @Test
	public void addNewEventDetailsTest() {
    	Venue venue = new Venue("Olvi Areena", "Hannes Kolehmaisen katu 4", "Kuopio", 5000);
		vrepository.save(venue);
		
		Event event = new Event(venue, "KalPa - Kärpät", LocalDate.of(2023, 11, 17), LocalTime.of(18, 30));
		erepository.save(event);
		
		TicketType tickettype1 = new TicketType(25.00, "Student", "Seat A 34", event);
		ttrepository.save(tickettype1);
		
		TicketType tickettype2 = new TicketType(40.00, "Adult", "Seat A 35", event);
		ttrepository.save(tickettype2);
		
		List<TicketType> tickettypes = ttrepository.findByTicketName("Student");
		assertThat(tickettypes.get(0).getTicketName().equals("Student"));
	}

	//Find event by venue name
	@Test 
    	public void findEventByVenue() {
    	List<Event> event = erepository.findByVenueName("Olvi Areena");
    	assertThat(event).hasSize(0);
    	}

	//Deletes venue by id
   	@Test
	public void deleteVenueById() {
    	Venue venue = new Venue();
		venue.setName("Stadium");
		venue.setAddress("123 Street");
		venue.setCity("City");
		vrepository.save(venue);
		vrepository.deleteById(venue.getVenueId());
		List<Venue> venues = vrepository.findByName("Stadium");
		assertEquals(1, venues.size());
	}
    
}
