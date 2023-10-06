package kkvvsolutions.TicketGuru.domain;

import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;

	@ManyToOne
	@JoinColumn(name = "eventId")
	private Event event;

	@ManyToOne
	@JoinColumn(name = "ticketTypeId")
	private TicketType ticketType;

	@ManyToOne
	@JoinColumn(name = "saleEventId")
	@JsonIgnore
	private SaleEvent saleEvent;

	private String barcode;

	private static final AtomicLong counter = new AtomicLong();

	public Ticket() {
		this.barcode = generateBarcode();
	}

	public Ticket(Event event, TicketType ticketType, SaleEvent saleEvent) {
		super();
		this.event = event;
		this.ticketType = ticketType;
		this.saleEvent = saleEvent;

		if (saleEvent != null) {
			saleEvent.getTicketList().add(this);
		}
	}

	private String generateBarcode() {
		long currentTime = System.currentTimeMillis();
		long count = counter.incrementAndGet();
		return String.valueOf(currentTime) + String.format("%04d", count % 10000);
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public SaleEvent getSaleEvent() {
		return saleEvent;
	}

	public void setSaleEvent(SaleEvent saleEvent) {
		this.saleEvent = saleEvent;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", event=" + event + ", ticketType=" + ticketType + ", saleEvent="
				+ saleEvent + ", barcode=" + barcode + "]";
	}

}
