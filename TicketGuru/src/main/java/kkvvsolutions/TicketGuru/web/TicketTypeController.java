package kkvvsolutions.TicketGuru.web;

import kkvvsolutions.TicketGuru.domain.TicketType;
import kkvvsolutions.TicketGuru.domain.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TicketTypeController {

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    @GetMapping("/tickettypes")
    public String listTicketTypes(Model model) {
        model.addAttribute("ticketTypes", ticketTypeRepository.findAll());
        return "tickettypelist";
    }

    @GetMapping("/addtickettype")
    public String addTicketType(Model model) {
        model.addAttribute("ticketType", new TicketType());
        return "addtickettype";
    }

    @PostMapping("/savetickettype")
    public String saveTicketType(@ModelAttribute TicketType ticketType) {
        ticketTypeRepository.save(ticketType);
        return "redirect:/tickettypes";
    }

    @GetMapping("/deletetickettype/{id}")
    public String deleteTicketType(@PathVariable("id") Long typeId) {
        ticketTypeRepository.deleteById(typeId);
        return "redirect:/tickettypes";
    }

    @GetMapping("/edittickettype/{id}")
    public String editTicketType(@PathVariable("id") Long typeId, Model model) {
        Optional<TicketType> ticketType = ticketTypeRepository.findById(typeId);
        if (ticketType.isPresent()) {
            model.addAttribute("ticketType", ticketType.get());
            return "edittickettype";
        }
        return "redirect:/tickettypes";
    }

    @PostMapping("/edittickettype")
    public String editTicketType(@ModelAttribute TicketType ticketType) {
        ticketTypeRepository.save(ticketType);
        return "redirect:/tickettypes";
    }
}
