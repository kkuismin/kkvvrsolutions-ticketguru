package kkvvsolutions.TicketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kkvvsolutions.TicketGuru.domain.repository.*;

@Controller
public class TicketGuruController {

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private SaleEventRepository saleEventRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("venues", venueRepository.findAll());
        model.addAttribute("events", eventRepository.findAll());
        model.addAttribute("ticketTypes", ticketTypeRepository.findAll());
        model.addAttribute("tickets", ticketRepository.findAll());
        model.addAttribute("saleEvents", saleEventRepository.findAll());
        return "index";
    }

}
