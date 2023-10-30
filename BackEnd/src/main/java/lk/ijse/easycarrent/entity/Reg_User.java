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
public class Reg_User {
    @Id
    private String userId;

    @Embedded
    private Name name;
    private String contactNo;
    private String address;
    private String email;
    private String nic;
    private String licenseNo;
    private String nicImg;
    private String licenseImg;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
