package Com.Service;



import Com.Domain.Ticket;
import Com.Repository.IRepo;
import Com.Repository.TicketInterface;
import Com.Repository.TicketRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TicketService implements TicketServInt {
    private TicketInterface ticketInterface;

    public TicketService(TicketInterface ticketInterface) {
        this.ticketInterface = ticketInterface;
    }

    @Transactional
    public Ticket create(Ticket ticket) {
        return ticketInterface.create(ticket);
    }

    @Transactional(readOnly = true)
    public Ticket get(Long id) {
        return ticketInterface.get(id);
    }

    @Transactional(readOnly = true)
    public List<Ticket> getAll() {
        return ticketInterface.getAll();
    }

    @Transactional
    public Ticket update(Ticket ticket) {
        return ticketInterface.update(ticket);
    }

    @Transactional
    public void delete(Long id) {
        ticketInterface.delete(id);
    }
}
