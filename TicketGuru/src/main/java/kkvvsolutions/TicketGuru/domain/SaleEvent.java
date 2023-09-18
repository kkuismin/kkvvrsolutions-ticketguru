package kkvvsolutions.TicketGuru.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class SaleEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SaleEvent_id;
	
	@OneToMany
	@JoinColumn(name = "ticket_id")
	private Ticket ticket;
	
	private LocalDate SaleDate;
	private LocalTime SaleTime;
	
	public SaleEvent() {
		super();
		
	}

	public Long getSaleEvent_id() {
		return SaleEvent_id;
	}

	public void setSaleEvent_id(Long saleEvent_id) {
		SaleEvent_id = saleEvent_id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public LocalDate getSaleDate() {
		return SaleDate;
	}

	public void setSaleDate(LocalDate saleDate) {
		SaleDate = saleDate;
	}

	public LocalTime getSaleTime() {
		return SaleTime;
	}

	public void setSaleTime(LocalTime saleTime) {
		SaleTime = saleTime;
	}
}