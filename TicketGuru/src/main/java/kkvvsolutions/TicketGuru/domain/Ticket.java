package kkvvsolutions.TicketGuru.domain;


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
	@JoinColumn(name = "saleEventId")
	private SaleEvent saleEvent;
	
	private String barcode, type;
	
	public Ticket() {
		super();
	}
	
	public Ticket(Long ticketId, String barcode, String type) {
		super();
		this.ticketId = ticketId;
		this.barcode = barcode;
		this.type = type;
	}
	
	public Ticket(String barcode, String type) {
		super();
		this.barcode = barcode;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", event=" + event + ", saleEvent=" + saleEvent + ", barcode="
				+ barcode + ", type=" + type + "]";
	}
	
}
