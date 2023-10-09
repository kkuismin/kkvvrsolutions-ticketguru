package kkvvsolutions.TicketGuru.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
	private Long saleEventId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "saleEvent")
	private List<Ticket> ticketList = new ArrayList<>();

	private LocalDate saleDate;
	private LocalTime saleTime;
	private double amount;

	public SaleEvent() {
		super();
		this.saleDate = LocalDate.now();
		this.saleTime = LocalTime.now();
	}

	public SaleEvent(double amount, List<Ticket> tickets) {
		this();
		this.amount = amount;
		this.ticketList = tickets;
		for (Ticket ticket : tickets) {
			ticket.setSaleEvent(this);
		}
	}

	public Long getSaleEventId() {
		return saleEventId;
	}

	public void setSaleEventId(Long saleEventId) {
		this.saleEventId = saleEventId;
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}

	public LocalTime getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(LocalTime saleTime) {
		this.saleTime = saleTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "SaleEvent [saleEventId=" + saleEventId + ", ticketList=" + ticketList + ", saleDate=" + saleDate
				+ ", saleTime=" + saleTime + ", amount=" + amount + "]";
	}

}
