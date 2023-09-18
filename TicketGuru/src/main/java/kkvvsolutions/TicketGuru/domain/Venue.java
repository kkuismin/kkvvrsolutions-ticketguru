package kkvvsolutions.TicketGuru.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long venue_id;
	
	private String name;
	private String address;
	private String city;
	private int capacity;
	
	public Venue() {
		super();
	}

	public Long getVenue_id() {
		return venue_id;
	}

	public void setVenue_id(Long venue_id) {
		this.venue_id = venue_id;
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

	@Override
	public String toString() {
		return "Venue [venue_id=" + venue_id + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", capacity=" + capacity + "]";
	}
}
