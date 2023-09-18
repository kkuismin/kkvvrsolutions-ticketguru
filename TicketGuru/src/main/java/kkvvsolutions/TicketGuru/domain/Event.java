package kkvvsolutions.TicketGuru.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name, date, time;
	
	public Event() {
		super();
	}

	public Event(long id, String name, String date, String time) {
		super();
		this.id = id;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return "Event [id=" + id + ", name=" + name + ", date=" + date + ", time=" + time + "]";
	}
	
}
