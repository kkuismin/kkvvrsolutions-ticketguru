package kkvvsolutions.TicketGuru.web;

import kkvvsolutions.TicketGuru.domain.Venue;
import kkvvsolutions.TicketGuru.domain.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestVenueController {

    @Autowired
    private VenueRepository venueRepository;

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

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/venues/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable("id") Long venue_id) {
        Optional<Venue> venueData = venueRepository.findById(venue_id);

        if (venueData.isPresent()) {
            return new ResponseEntity<>(venueData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/venues")
    public ResponseEntity<Venue> createVenue(@RequestBody Venue venue) {
        try {
            Venue _venue = venueRepository
                    .save(new Venue(venue.getName(), venue.getAddress(), venue.getCity(), venue.getCapacity()));
            return new ResponseEntity<>(_venue, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/venues/{id}")
    public ResponseEntity<Venue> updateVenue(@PathVariable("id") Long venue_id, @RequestBody Venue venue) {
        Optional<Venue> venueData = venueRepository.findById(venue_id);

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

    @DeleteMapping("/venues/{id}")
    public ResponseEntity<HttpStatus> deleteVenue(@PathVariable("id") Long venue_id) {
        try {
            venueRepository.deleteById(venue_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/venues")
    public ResponseEntity<HttpStatus> deleteAllVenues() {
        try {
            venueRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
