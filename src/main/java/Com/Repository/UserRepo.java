package Com.Repository;


import Com.Domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo implements IRepo<User, Integer, User>, IRepoUserRet<User>{
    private SessionFactory sessionFactory;

    public UserRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("from User", User.class);
        return userQuery.getResultList();
    }

    public User create(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    @Override
    public User get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    public User update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        return user;
    }

    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        User user = get(id);
        if (user != null) {
            session.delete(user);
        }
    }

    @Override
    public User getByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("from User where username = :username", User.class);
        userQuery.setParameter("username", username);
        return userQuery.getSingleResult();
    }
}
