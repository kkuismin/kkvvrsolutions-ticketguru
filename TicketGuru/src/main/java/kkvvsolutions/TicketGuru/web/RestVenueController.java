package kkvvsolutions.TicketGuru.web;

import kkvvsolutions.TicketGuru.domain.Venue;
import kkvvsolutions.TicketGuru.domain.repository.VenueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestVenueController {

    @Autowired
    private VenueRepository venueRepository;

    // Endpoint to retrieve all venues
    @GetMapping("/venues")
    public ResponseEntity<List<Venue>> getAllVenues() {
        try {

            List<Venue> venues = new ArrayList<>();
            venueRepository.findAll().forEach(venues::add);

            if (venues.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(venues, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint to retrieve a venue by its ID
    @GetMapping("/venues/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable("id") Long venueId) {
        Optional<Venue> venueData = venueRepository.findById(venueId);

        if (venueData.isPresent()) {
            return new ResponseEntity<>(venueData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to create a new venue
    @PostMapping("/venues")
    public ResponseEntity<Venue> createVenue(@Valid @RequestBody Venue venue) {
        try {
            Venue _venue = venueRepository
                    .save(new Venue(venue.getName(), venue.getAddress(), venue.getCity(), venue.getCapacity()));
            return new ResponseEntity<>(_venue, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint to update a venue by its ID
    @PutMapping("/venues/{id}")
    public ResponseEntity<Venue> updateVenue(@PathVariable("id") Long venueId, @Valid @RequestBody Venue venue) {
        Optional<Venue> venueData = venueRepository.findById(venueId);

        if (venueData.isPresent()) {
            Venue _venue = venueData.get();
            _venue.setName(venue.getName());
            _venue.setAddress(venue.getAddress());
            _venue.setCity(venue.getCity());
            _venue.setCapacity(venue.getCapacity());

            return new ResponseEntity<>(venueRepository.save(_venue), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a venue by its ID
    @DeleteMapping("/venues/{id}")
    public ResponseEntity<HttpStatus> deleteVenue(@PathVariable("id") Long venueId) {
        try {
            venueRepository.deleteById(venueId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete all venues
    @DeleteMapping("/venues")
    public ResponseEntity<HttpStatus> deleteAllVenues() {
        try {
            venueRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
