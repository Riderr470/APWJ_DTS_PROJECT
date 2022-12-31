package Com.Controller;

import Com.Domain.Authority;
import Com.Service.AuthorityServInt;
import Com.Exception.BadRequestAlertException;
import Com.Exception.NotFoundAlertException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthorityController {

    private AuthorityServInt authorityServInt;

    public AuthorityController(AuthorityServInt authorityServInt) {
        this.authorityServInt = authorityServInt;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/authorities")
    public ResponseEntity<Authority> createAuthority(@Valid @RequestBody Authority authority) throws Exception {
        if (authority.getId() != null) {
            throw new BadRequestAlertException("A new authority cannot have an id value");
        }
        authorityServInt.create(authority);
        return ResponseEntity.created(new URI("/authorities/"))
                .body(authority);
    }

    @PutMapping("/authorities")
    public ResponseEntity<Authority> updateAuthority(@Valid @RequestBody Authority authority) throws Exception {
        if (authority.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        authorityServInt.update(authority);
        return ResponseEntity.created(new URI("/authorities/"))
                .body(authority);
    }

    @GetMapping("/authorities")
    public ResponseEntity<List<Authority>> getAllAuthorities() {
        List<Authority> authorities = authorityServInt.getAll();
        return ResponseEntity.ok().body(authorities);
    }

    @GetMapping("/authorities/{id}")
    public ResponseEntity<Authority> getAuthority(@PathVariable Long id) {
        Optional<Authority> authority = Optional.ofNullable(authorityServInt.get(id));
        if (authority.isPresent()) {
            return ResponseEntity.ok().body(authority.get());
        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }

    @DeleteMapping("/authorities/{id}")
    public ResponseEntity<Authority> deleteAuthority(@PathVariable Long id) {
        authorityServInt.delete(id);
        return ResponseEntity.noContent().build();
    }
}
