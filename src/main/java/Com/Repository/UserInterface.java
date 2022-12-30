package Com.Repository;

import Com.Domain.User;

import java.util.List;

public interface UserInterface {
    public List<User> getAll();

    public User create(User user);

    public User get(Long id);

    public User update(User user);

    public void delete(Long id);

    public User getByUsername(String username);
}
