package Com.Repository;

import Com.Domain.Destination;
import Com.Domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DestinationRepo implements IRepo<Destination, Integer, Destination>{
    private SessionFactory sessionFactory;

    public DestinationRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Destination> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Destination> DestinationQuery = session.createQuery("from Destination", Destination.class);
        return DestinationQuery.getResultList();
    }

    public Destination create(Destination destination) {
        Session session = sessionFactory.getCurrentSession();
        session.save(destination);
        return destination;
    }

    @Override
    public Destination get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Destination.class, id);
    }

    public Destination update(Destination destination) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(destination);
        return destination;
    }

    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Destination destination = get(id);
        if (destination != null) {
            session.delete(destination);
        }
    }
}
