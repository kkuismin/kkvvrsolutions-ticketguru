package kkvvsolutions.TicketGuru.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId; 
    private Double price; 
    private String customerType; 
    private String description; 

    @OneToMany(mappedBy = "ticketType")
    private List<Event> tickets;
    
    public TicketType() {}

    public TicketType(Double price, String customerType, String description) {
        super();
        this.price = price;
        this.customerType = customerType;
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

	@Override
	public String toString() {
		return "TicketType [typeId=" + typeId + ", price=" + price + ", customerType=" + customerType + ", description="
				+ description + "]";
	}

}
