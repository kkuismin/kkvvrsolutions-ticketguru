package kkvvsolutions.TicketGuru.domain;

import java.util.List;
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
	private long event_id;

	@ManyToOne
	@JoinColumn(name = "ticket_id")
	private Ticket ticket;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "event")
	private List <TicketType> ticketTypeList;

	@ManyToOne
	@JoinColumn(name = "venue_id")
	private Venue venue;
	
	private String name, date, time;
	
	public Event() {
		super();
	}

	public Event(long event_id, String name, String date, String time) {
		super();
		this.event_id = event_id;
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

	public long getEvent_id() {
		return event_id;
	}

	public void setEvent_id(long event_id) {
		this.event_id = event_id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public List<TicketType> getTicketTypeList() {
		return ticketTypeList;
	}

	public void setTicketTypeList(List<TicketType> ticketTypeList) {
		this.ticketTypeList = ticketTypeList;
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
		return "Event [event_id=" + event_id + ", name=" + name + ", date=" + date + ", time=" + time + "]";
	}
	
}
