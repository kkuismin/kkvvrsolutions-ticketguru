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
	private Long ticket_id;
	
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
	
	@ManyToOne
	@JoinColumn(name = "saleEvent_id")
	private SaleEvent saleEvent;
	
	private String barcode;
	
	private String type;
	
	public Ticket() {
		super();
	}
	
	public Ticket(String barcode) {
		this.barcode = barcode;
	}

	public Long getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(Long ticket_id) {
		this.ticket_id = ticket_id;
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
		return "Ticket [ticket_id=" + ticket_id + ", event=" + event + ", saleEvent=" + saleEvent + ", barcode="
				+ barcode + ", type=" + type + "]";
	}
	
}
