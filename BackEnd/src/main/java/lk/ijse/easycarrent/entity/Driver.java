package lk.ijse.easycarrent.entity;

import lk.ijse.easycarrent.embeded.Name;
import lk.ijse.easycarrent.enums.AvailabilityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Driver {
    @Id
    private String userId;
    @Embedded
    private Name name;
    private String contactNo;
    private String address;
    private String email;
    private String nicNo;
    private String licenseNo;
    private String licenseImg;
    @Enumerated(EnumType.STRING)
    private AvailabilityType driverAvailability;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

}
