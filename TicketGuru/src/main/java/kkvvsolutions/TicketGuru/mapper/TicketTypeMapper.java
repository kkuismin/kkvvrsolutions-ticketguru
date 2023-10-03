package kkvvsolutions.TicketGuru.mapper;

import kkvvsolutions.TicketGuru.domain.TicketType;
import kkvvsolutions.TicketGuru.dto.TicketTypeDTO;
import kkvvsolutions.TicketGuru.dto.TicketTypeCreationDTO;

import org.springframework.stereotype.Component;

@Component
public class TicketTypeMapper {

    public TicketTypeDTO toDto(TicketType ticketType) {
        TicketTypeDTO dto = new TicketTypeDTO();
        dto.setPrice(ticketType.getPrice());
        dto.setCustomerType(ticketType.getCustomerType());
        dto.setDescription(ticketType.getDescription());
        dto.setEventId(ticketType.getEvent().getEventId());
        return dto;
    }

    public TicketType toEntity(TicketTypeCreationDTO dto) {
        TicketType ticketType = new TicketType();
        ticketType.setPrice(dto.getPrice());
        ticketType.setCustomerType(dto.getCustomerType());
        ticketType.setDescription(dto.getDescription());

        return ticketType;
    }
}
