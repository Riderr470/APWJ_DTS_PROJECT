package Com.Service;

import Com.Domain.Ticket;

import java.util.List;

public interface TicketServInt {
    public Ticket create(Ticket ticket);

    public Ticket get(Long id);

    public List<Ticket> getAll();

    public Ticket update(Ticket ticket);

    public void delete(Long id);
}
