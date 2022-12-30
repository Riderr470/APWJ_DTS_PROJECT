package Com.Repository;

import Com.Domain.Authority;
import Com.Domain.Ticket;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepo implements TicketInterface{
    private SessionFactory sessionFactory;

    public TicketRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Ticket> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Ticket> TicketQuery = session.createQuery("from Ticket", Ticket.class);
        return TicketQuery.getResultList();
    }

    public Ticket create(Ticket ticket) {
        Session session = sessionFactory.getCurrentSession();
        session.save(ticket);
        return ticket;
    }

    public Ticket get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Ticket.class, id);
    }

    public Ticket update(Ticket ticket) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(ticket);
        return ticket;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Ticket ticket = get(id);
        if (ticket != null) {
            session.delete(ticket);
        }
    }
}
