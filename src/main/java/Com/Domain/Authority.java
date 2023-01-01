package Com.Domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotNull
    @Column(name = "role")
    private String RoleName;

    public Authority() {
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority_map",
            joinColumns = @JoinColumn(name = "authority_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> user;

    public void setId(Long id) {
        Id = id;
    }
    public void setRoleName(String roleName) {
        RoleName = roleName;
    }
    public void setUsers(List<User> user) {
        this.user = user;
    }

    public Long getId() {
        return Id;
    }
    public String getRoleName() {
        return RoleName;
    }
    public List<User> getUser() {
        return user;
    }
    @Override
    public String getAuthority() {
        return RoleName;
    }
}
