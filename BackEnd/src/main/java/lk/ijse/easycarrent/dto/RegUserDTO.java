package lk.ijse.easycarrent.dto;


import lk.ijse.easycarrent.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegUserDTO {
    private String userId;
    private Name name;
    private String contactNo;
    private String address;
    private String email;
    private String nic;
    private String licenseNo;
    private MultipartFile nicImg;
    private MultipartFile licenseImg;

    private UserDTO user;

}