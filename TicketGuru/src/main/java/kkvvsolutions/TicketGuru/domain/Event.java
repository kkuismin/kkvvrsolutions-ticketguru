package kkvvsolutions.TicketGuru.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long eventId;

    @ManyToOne
    @JoinColumn(name = "venueId")
    @JsonIgnore
    private Venue venue;
    
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<TicketType> ticketTypes = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    
    private String name;
    private String date;
    private String time;
	
	public Event() {
		super();
	}

	public Event(long eventId, String name, String date, String time) {
		super();
		this.eventId = eventId;
		this.name = name;
		this.date = date;
		this.time = time;
	}

	public Event(String name, String date, String time) {
		super();
		this.name = name;
		this.date = date;
		this.time = time;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}


	public List<TicketType> getTicketTypes() {
		return ticketTypes;
	}

	public void addTicketType(TicketType ticketType) {
	    if (this.ticketTypes == null) {
	        this.ticketTypes = new ArrayList<>();
	    }
	    this.ticketTypes.add(ticketType);
	    ticketType.setEvent(this); 
	}



	public List<Ticket> getTickets() {
		return tickets;
	}

	public void addTickets(Ticket ticket) {
	    if (this.tickets == null) {
	        this.tickets = new ArrayList<>();
	    }
	    this.tickets.add(ticket);
	    ticket.setEvent(this); 
	}


	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", name=" + name + ", date=" + date + ", time=" + time + "]";
	}
	
}