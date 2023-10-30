package lk.ijse.easycarrent.dto;

import lk.ijse.easycarrent.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminDTO {
    private String userId;
    private Name name;
    private String contactNo;
    private String address;
    private String email;
    private String nic;

    private UserDTO user;

}