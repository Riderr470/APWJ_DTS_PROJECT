package Com.Service;

import Com.Domain.User;

import java.util.List;

public interface UserServInt {
    public User create(User user);

    public User get(Long id);

    public List<User> getAll();

    public User update(User user);

    public void delete(Long id);
}
