package kkvvsolutions.TicketGuru.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "saleevent")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "saleEventId")
public class SaleEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "saleeventid", nullable = false, updatable = false)
	private Long saleEventId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "saleEvent")
	private List<Ticket> ticketList = new ArrayList<>();

	@NotNull
	@Column(name = "saledate", nullable = false)
	private LocalDate saleDate;

	@NotNull
	@Column(name = "saletime", nullable = false)
	private LocalTime saleTime;

	@NotNull
	@Column(name = "amount", nullable = false)
	@Min(1)
	private int amount;

	public SaleEvent() {
		super();
		this.saleDate = LocalDate.now();
		this.saleTime = LocalTime.now();
	}

	public SaleEvent(int amount, List<Ticket> tickets) {
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "SaleEvent [saleEventId=" + saleEventId + ", ticketList=" + ticketList + ", saleDate=" + saleDate
				+ ", saleTime=" + saleTime + ", amount=" + amount + "]";
	}

}
