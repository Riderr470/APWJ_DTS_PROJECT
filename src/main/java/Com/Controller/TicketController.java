package Com.Controller;

import Com.Domain.Authority;
import Com.Domain.Ticket;
import Com.Exception.BadRequestAlertException;
import Com.Exception.NotFoundAlertException;
import Com.Service.AuthorityServInt;
import Com.Service.TicketServInt;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TicketController {
    private TicketServInt ticketServInt;

    public TicketController(TicketServInt ticketServInt) {
        this.ticketServInt = ticketServInt;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/ticket")
    public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket) throws Exception {
        if (ticket.getId() != null) {
            throw new BadRequestAlertException("A new authority cannot have an id value");
        }
        ticketServInt.create(ticket);
        return ResponseEntity.created(new URI("/ticket/"))
                .body(ticket);
    }

    @PutMapping("/ticket")
    public ResponseEntity<Ticket> updateTicket(@Valid @RequestBody Ticket ticket) throws Exception {
        if (ticket.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        ticketServInt.update(ticket);
        return ResponseEntity.created(new URI("/ticket/"))
                .body(ticket);
    }

    @GetMapping("/ticket")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketServInt.getAll();
        return ResponseEntity.ok().body(tickets);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTickets(@PathVariable Long id) {
        Optional<Ticket> ticket = Optional.ofNullable(ticketServInt.get(id));
        if (ticket.isPresent()) {
            return ResponseEntity.ok().body(ticket.get());
        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }

    @DeleteMapping("/ticket/{id}")
    public ResponseEntity<Ticket> deleteTickets(@PathVariable Long id) {
        ticketServInt.delete(id);
        return ResponseEntity.noContent().build();
    }
}
