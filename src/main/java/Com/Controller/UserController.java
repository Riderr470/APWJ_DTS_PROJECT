package Com.Controller;

import Com.Domain.User;
import Com.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user) throws URISyntaxException {
        User newUser = userService.create(user);
        return ResponseEntity.created(new URI("/register"))
                .body(null);
    }

}
