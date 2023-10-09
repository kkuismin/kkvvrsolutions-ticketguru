package kkvvsolutions.TicketGuru.dto;

public class TicketTypeCreationDTO {

    private Long ticketTypeId;
    private Double price;
    private String ticketType;
    private String description;
    private Long eventId;

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

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketTypeType(String ticketType) {
        this.ticketType = ticketType;
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

    @Override
    public String toString() {
        return "TicketTypeCreationDTO [ticketTypeId=" + ticketTypeId + ", price=" + price + ", ticketType=" + ticketType
                + ", description=" + description + ", eventId=" + eventId + "]";
    }

}
