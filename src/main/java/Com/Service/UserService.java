package Com.Service;

import Com.Domain.User;
import Com.Repository.UserInterface;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserServInt {
    private UserInterface userInterface;

    private PasswordEncoder passwordEncoder;

    public UserService(UserInterface userInterface, PasswordEncoder passwordEncoder) {
        this.userInterface = userInterface;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User create(User user) {
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userInterface.create(user);
    }

    @Transactional(readOnly = true)
    public User get(Long id) {
        return userInterface.get(id);
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userInterface.getAll();
    }

    @Transactional
    public User update(User user) {
        return userInterface.update(user);
    }

    @Transactional
    public void delete(Long id) {
        userInterface.delete(id);
    }

    @Transactional(readOnly = true)
    public User getByUsername(String username) { return userInterface.getByUsername(username); }

   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }*/

}
