package kkvvsolutions.TicketGuru.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class SaleEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SaleEvent_id;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "saleEvent")
	private List <Ticket> ticketList;
	
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

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
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