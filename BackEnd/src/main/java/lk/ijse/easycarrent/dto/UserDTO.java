package lk.ijse.easycarrent.dto;


import lk.ijse.easycarrent.enums.RoleType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
public class UserDTO {
    private String userId;
    private RoleType roleType;
    private String userName;
    private String password;

    public UserDTO(RoleType roleType, String userName, String password) {
        this.roleType = roleType;
        this.userName = userName;
        this.password = password;
    }

}
