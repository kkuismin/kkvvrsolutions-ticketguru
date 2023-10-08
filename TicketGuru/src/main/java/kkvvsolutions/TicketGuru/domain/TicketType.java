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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typeId", nullable = false, updatable = false)
    private Long typeId;
    
    @NotNull
    private Double price;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String ticketType;

    @Size(min = 1, max = 100)
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

    public TicketType(long typeId, Event event, Double price, String ticketType, String description) {
        super();
        this.typeId = typeId;
        this.event = event;
        this.price = price;
        this.ticketType = ticketType;
        this.description = description;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
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
