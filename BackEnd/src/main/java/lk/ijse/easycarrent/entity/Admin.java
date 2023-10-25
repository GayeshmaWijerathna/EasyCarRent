package lk.ijse.easycarrent.entity;

import lk.ijse.easycarrent.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin {
    @Id
    private String user_Id;

    @Embedded
    private Name name;
    private String contactNo;
    private String address;
    private String email;
    private String nic;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
