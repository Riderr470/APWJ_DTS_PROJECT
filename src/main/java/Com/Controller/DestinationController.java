package Com.Controller;

import Com.Domain.Authority;
import Com.Domain.Destination;
import Com.Exception.BadRequestAlertException;
import Com.Exception.NotFoundAlertException;
import Com.Service.AuthorityServInt;
import Com.Service.DestinationServInt;
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
public class DestinationController {
    private DestinationServInt destinationServInt;

    public DestinationController(DestinationServInt destinationServInt) {
        this.destinationServInt = destinationServInt;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/adm/destination")
    public ResponseEntity<Destination> createDestination(@Valid @RequestBody Destination destination) throws Exception {
        if (destination.getId() != null) {
            throw new BadRequestAlertException("A new authority cannot have an id value");
        }
        destinationServInt.create(destination);
        return ResponseEntity.created(new URI("/destination/"))
                .body(destination);
    }

    @PutMapping("/adm/destination")
    public ResponseEntity<Destination> updateDestination(@Valid @RequestBody Destination destination) throws Exception {
        if (destination.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        destinationServInt.update(destination);
        return ResponseEntity.created(new URI("/destination/"))
                .body(destination);
    }

    @GetMapping("/destination")
    public ResponseEntity<List<Destination>> getAllDestinations() {
        List<Destination> destinations = destinationServInt.getAll();
        return ResponseEntity.ok().body(destinations);
    }

    @GetMapping("/destination/{id}")
    public ResponseEntity<Destination> getDestination(@PathVariable Long id) {
        Optional<Destination> destination = Optional.ofNullable(destinationServInt.get(id));
        if (destination.isPresent()) {
            return ResponseEntity.ok().body(destination.get());
        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }

    @DeleteMapping("/adm/destination/{id}")
    public ResponseEntity<Destination> deleteDestination(@PathVariable Long id) {
        destinationServInt.delete(id);
        return ResponseEntity.noContent().build();
    }
}
