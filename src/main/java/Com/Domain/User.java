package Com.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class User {
    @Id
    private int Id;
    private String Username;
    private String Email;
    private String Password;
    private String Phone;
    private String Role;
    private String Status;

    public void setId(int id){
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
    public void setRole(String role){
        this.Role = role;
    }
    public void setStatus(String status){
        this.Status = status;
    }

    public int getId() {
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
    public String getRole() {
        return Role;
    }
    public String getStatus() {
        return Status;
    }
}
