package kkvvsolutions.TicketGuru.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long venueId;

	private String name;
	private String address;
	private String city;
	private int capacity;

	@OneToMany(mappedBy = "venue", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Event> events = new ArrayList<>();

	public Venue() {
		super();
	}

	public Venue(String name, String address, String city, int capacity) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.capacity = capacity;
	}

	public Long getVenueId() {
		return venueId;
	}

	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Venue [venueId=" + venueId + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", capacity=" + capacity + "]";
	}
}
