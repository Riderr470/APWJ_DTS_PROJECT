package Com.Domain;

import javax.persistence.*;

@Entity
public class Authority {
    @Id
    private int Id;
    private String RoleName;

    public void setId(int id) {
        Id = id;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public int getId() {
        return Id;
    }

    public String getRoleName() {
        return RoleName;
    }
}
