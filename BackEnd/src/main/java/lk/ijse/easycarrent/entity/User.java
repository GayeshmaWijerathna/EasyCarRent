package lk.ijse.easycarrent.entity;

import lk.ijse.easycarrent.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {
    @Id
    private String userId;
    @Enumerated(EnumType.STRING)
    private RoleType roleType ;
    private String useName;
    private String password;

    public User(RoleType roleType, String useName, String password) {
        this.roleType = roleType;
        this.useName = useName;
        this.password = password;
    }
}
