package kkvvsolutions.TicketGuru.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventId", nullable = false, updatable = false)
	private long eventId;

	@ManyToOne
	@JoinColumn(name = "venueId")
	private Venue venue;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	private List<TicketType> ticketTypes;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	private List<Ticket> tickets;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "date", nullable = false)
	private String date;
	
	@Column(name = "time", nullable = false)
	private String time;
	

	public Event() {
		super();
	}
	

	public Event(long eventId, Venue venue, List<TicketType> ticketTypes, List<Ticket> tickets, String name,
			String date, String time) {
		super();
		this.eventId = eventId;
		this.venue = venue;
		this.ticketTypes = ticketTypes;
		this.tickets = tickets;
		this.name = name;
		this.date = date;
		this.time = time;
	}

	public Event (String name, String date, String time) {
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


	public Venue getVenue() {
		return venue;
	}


	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	public List<TicketType> getTicketTypes() {
		return ticketTypes;
	}


	public void setTicketTypes(List<TicketType> ticketTypes) {
		this.ticketTypes = ticketTypes;
	}


	public List<Ticket> getTickets() {
		return tickets;
	}


	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
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
		return "Event [eventId=" + eventId + ", venue=" + venue + ", ticketTypes=" + ticketTypes + ", tickets="
				+ tickets + ", name=" + name + ", date=" + date + ", time=" + time + "]";
	}
	

}
