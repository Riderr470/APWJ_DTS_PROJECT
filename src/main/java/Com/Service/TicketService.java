package Com.Service;



import Com.Domain.Ticket;
import Com.Repository.IRepo;
import Com.Repository.TicketRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TicketService implements IRepo<Ticket, Integer, Ticket> {
    private TicketRepo ticketRepo;

    public TicketService(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @Transactional
    public Ticket create(Ticket ticket) {
        return ticketRepo.create(ticket);
    }

    @Transactional(readOnly = true)
    public Ticket get(Integer id) {
        return ticketRepo.get(id);
    }

    @Transactional(readOnly = true)
    public List<Ticket> getAll() {
        return ticketRepo.getAll();
    }

    @Transactional
    public Ticket update(Ticket ticket) {
        return ticketRepo.update(ticket);
    }

    @Transactional
    public void delete(Integer id) {
        ticketRepo.delete(id);
    }
}
