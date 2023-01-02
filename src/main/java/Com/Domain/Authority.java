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
    @Column(name = "roleName")
    private String RoleName;

    public Authority() {
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority_map",
            joinColumns = @JoinColumn(name = "authority_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    //@ManyToMany(mappedBy = "authorities")
    private List<User> users;

    public void setId(Long id) {
        Id = id;
    }
    public void setRoleName(String roleName) {
        RoleName = roleName;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return Id;
    }
    public String getRoleName() {
        return RoleName;
    }
    public List<User> getUser() {
        return users;
    }
    @Override
    public String getAuthority() {
        return RoleName;
    }
}
