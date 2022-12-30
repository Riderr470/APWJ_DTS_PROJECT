package Com.Service;

import Com.Domain.User;
import Com.Repository.IRepo;
import Com.Repository.IRepoUserRet;
import Com.Repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IRepo<User,Integer,User> {
    private UserRepo userRepository;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.create(user);
    }

    @Transactional(readOnly = true)
    public User get(Integer id) {
        return userRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Transactional
    public User update(User user) {
        return userRepository.update(user);
    }

    @Transactional
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public User getByUsername(String username) { return userRepository.getByUsername(username); }

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }*/

}
