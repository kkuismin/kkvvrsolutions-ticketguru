package kkvvsolutions.TicketGuru.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    private Double price;
    private String ticketType;

    private String description;

    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;

    @JsonIgnore
    @OneToMany(mappedBy = "ticketType")
    private List<Ticket> tickets;

    public TicketType() {
        super();
    }

    public TicketType(Double price, String ticketType, String description, Event event) {
        super();
        this.price = price;
        this.ticketType = ticketType;
        this.description = description;
        this.event = event;
    }

    public Long getTicketTypeId() {
        return typeId;
    }

    public void setTicketTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
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
        return "TicketType [typeId=" + typeId + ", price=" + price + ", ticketType=" + ticketType + ", description="
                + description + ", event=" + event + ", tickets=" + tickets + "]";
    }

}
