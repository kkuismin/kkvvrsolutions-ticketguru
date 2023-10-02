package kkvvsolutions.TicketGuru.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kkvvsolutions.TicketGuru.domain.TicketType;
import kkvvsolutions.TicketGuru.domain.repository.TicketTypeRepository;
import kkvvsolutions.TicketGuru.dto.TicketTypeCreationDTO;
import kkvvsolutions.TicketGuru.dto.TicketTypeDTO;
import kkvvsolutions.TicketGuru.mapper.TicketTypeMapper;

@RestController
@RequestMapping("/api")
public class RestTicketTypeController {

	@Autowired
	private TicketTypeRepository repository;

	@Autowired
	private TicketTypeMapper mapper;

	@GetMapping("/tickettypes")
	public ResponseEntity<List<TicketTypeDTO>> getAllTicketTypes() {
		try {
			List<TicketType> ticketTypes = (List<TicketType>) repository.findAll();
			if (ticketTypes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			List<TicketTypeDTO> ticketTypeDTOs = ticketTypes.stream()
					.map(mapper::toDto)
					.collect(Collectors.toList());
			return new ResponseEntity<>(ticketTypeDTOs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tickettypes/{id}")
	public ResponseEntity<TicketTypeDTO> getTicketTypeById(@PathVariable("id") Long typeId) {
		Optional<TicketType> ticketTypeData = repository.findById(typeId);
		if (ticketTypeData.isPresent()) {
			TicketTypeDTO responseDTO = mapper.toDto(ticketTypeData.get());
			return new ResponseEntity<>(responseDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/tickettypes")
	public ResponseEntity<TicketTypeDTO> createTicketType(@RequestBody TicketTypeCreationDTO ticketTypeDTO) {
		TicketType ticketType = mapper.toEntity(ticketTypeDTO);
		TicketType savedTicketType = repository.save(ticketType);
		TicketTypeDTO responseDTO = mapper.toDto(savedTicketType);
		return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	}

	@PutMapping("/tickettypes/{id}")
	public ResponseEntity<TicketTypeDTO> updateTicketType(@PathVariable("id") Long typeId,
			@RequestBody TicketTypeCreationDTO ticketTypeDTO) {
		Optional<TicketType> ticketTypeData = repository.findById(typeId);
		if (ticketTypeData.isPresent()) {
			TicketType ticketTypeToUpdate = ticketTypeData.get();

			ticketTypeToUpdate.setPrice(ticketTypeDTO.getPrice());
			ticketTypeToUpdate.setCustomerType(ticketTypeDTO.getCustomerType());
			ticketTypeToUpdate.setDescription(ticketTypeDTO.getDescription());

			TicketType updatedTicketType = repository.save(ticketTypeToUpdate);
			TicketTypeDTO responseDTO = mapper.toDto(updatedTicketType);

			return new ResponseEntity<>(responseDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tickettypes")
	public ResponseEntity<HttpStatus> deleteAllTicketTypes() {

		try {
			repository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tickettypes/{id}")
	public ResponseEntity<HttpStatus> deleteTicketType(@PathVariable("id") Long typeId) {

		try {
			repository.deleteById(typeId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}