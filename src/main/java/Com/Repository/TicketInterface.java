package Com.Repository;

import Com.Domain.Ticket;

import java.util.List;

public interface TicketInterface {
    public List<Ticket> getAll();

    public Ticket create(Ticket ticket);

    public Ticket get(Long id);

    public Ticket update(Ticket ticket);

    public void delete(Long id);
}
