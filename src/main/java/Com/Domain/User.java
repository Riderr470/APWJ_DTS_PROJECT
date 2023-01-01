package Com.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotNull
    @Column(name = "Username")
    private String Username;
    @NotNull
    @Column(name = "Email")
    private String Email;
    @NotNull
    @Column(name = "Password")
    private String Password;
    @NotNull
    @Column(name = "Phone")
    private String Phone;
    @NotNull
    @Column(name = "Status")
    private String Status;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority_map",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private List<Authority> authorities;

    public void setId(Long id){
        this.Id = id;
    }
    public void setUsername(String username){
        this.Username = username;
    }
    public void setEmail(String email){
        this.Email = email;
    }
    public void setPassword(String password){
        this.Password = password;
    }
    public void setPhone(String phone){
        this.Phone = phone;
    }
    public void setStatus(String status){
        this.Status = status;
    }
    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public Long getId() {
        return Id;
    }
    public String getUsername() {
        return Username;
    }
    public String getEmail() {
        return Email;
    }
    public String getPassword() {
        return Password;
    }
    public String getPhone() {
        return Phone;
    }
    public String getStatus() {
        return Status;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }
}
