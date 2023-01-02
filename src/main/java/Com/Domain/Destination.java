package Com.Domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "destination")
public class Destination {
    @Id
    private Long Id;
    @NotNull
    @Column(name = "destinationName")
    private String DestinationName;

    public Long getId() {
        return Id;
    }
    public String getDestinationName() {
        return DestinationName;
    }

    public void setId(Long id) {
        Id = id;
    }
    public void setDestinationName(String destinationName) {
        DestinationName = destinationName;
    }
}
