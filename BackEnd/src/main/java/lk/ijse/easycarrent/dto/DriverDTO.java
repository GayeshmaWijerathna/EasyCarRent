package lk.ijse.easycarrent.dto;

import lk.ijse.easycarrent.embeded.Name;
import lk.ijse.easycarrent.enums.AvailabilityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DriverDTO {
    private String userId;
    private Name name;
    private String contactNo;
    private String address;
    private String email;
    private String nicNo;
    private String licenseNo;
    private MultipartFile licenseImg;
    private AvailabilityType driverAvailability;

    private UserDTO user;

}
