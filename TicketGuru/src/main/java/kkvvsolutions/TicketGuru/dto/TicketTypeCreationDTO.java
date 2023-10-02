package kkvvsolutions.TicketGuru.dto;

import java.util.List;

public class TicketTypeCreationDTO {

    private Double price;
    private String customerType;
    private String description;
    private Long eventId; // Assuming you want to set the associated event's ID when creating a TicketType

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

}
