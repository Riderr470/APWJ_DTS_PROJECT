package Com.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_authority_map")
public class user_authority_map {
    @Id
    private Long id;
    @NotNull
    @Column(name = "user_id")
    private Long user_id;
    @NotNull
    @Column(name = "authority_id")
    private Long authority_id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
