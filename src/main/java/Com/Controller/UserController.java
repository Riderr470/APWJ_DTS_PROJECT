package Com.Controller;

import Com.Domain.Authority;
import Com.Domain.User;
import Com.Exception.NotFoundAlertException;
import Com.Service.AuthorityServInt;
import Com.Service.AuthorityService;
import Com.Service.UserServInt;
import Com.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserServInt userServInt;
    private AuthorityServInt authorityServInt;
    private PasswordEncoder passwordEncoder;

    public UserController (UserServInt userServInt, AuthorityServInt authorityServInt, PasswordEncoder passwordEncoder) {
        this.userServInt = userServInt;
        this.passwordEncoder = passwordEncoder;
        this.authorityServInt = authorityServInt;
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user) throws URISyntaxException {
        User newUser = userServInt.create(user);
        return ResponseEntity.created(new URI("/register"))
                .body(null);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServInt.getAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUsers(@PathVariable Long id) {
        Optional<User> user = Optional.ofNullable(userServInt.get(id));
        if (user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }

}
