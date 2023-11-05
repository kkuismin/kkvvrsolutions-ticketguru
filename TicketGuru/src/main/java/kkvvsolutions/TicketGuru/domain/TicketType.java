package kkvvsolutions.TicketGuru.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tickettype")
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tickettypeid", nullable = false, updatable = false)
    private Long ticketTypeId;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "Ticket name cannot be null")
    @Size(min = 1, max = 100)
    @Column(name = "ticketname")
    private String ticketName;

    @Size(min = 1, max = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "eventid")
    private Event event;

    @JsonIgnore
    @OneToMany(mappedBy = "ticketType")
    private List<Ticket> tickets;

    public TicketType() {
        super();
    }

    public TicketType(Double price, String ticketName, String description, Event event) {
        super();
        this.event = event;
        this.price = price;
        this.ticketName = ticketName;
        this.description = description;
    }

    public Long getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "TicketType [ticketTypeId=" + ticketTypeId + ", price=" + price + ", ticketName=" + ticketName
                + ", description="
                + description + ", event=" + event + ", tickets=" + tickets + "]";
    }
}
