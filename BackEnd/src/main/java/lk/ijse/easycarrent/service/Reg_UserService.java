package lk.ijse.easycarrent.service;

import lk.ijse.easycarrent.dto.CustomDTO;
import lk.ijse.easycarrent.dto.RegUserDTO;
import lk.ijse.easycarrent.entity.Reg_User;

import java.util.ArrayList;

public interface Reg_UserService {
    void saveUser(RegUserDTO dto);
    void updateUser(RegUserDTO dto);
    void deleteUser(String regID);
    ArrayList<RegUserDTO> getAllUser();
    CustomDTO userIdGenerate();
    Reg_User searchUserId(String id);
    CustomDTO getSumUser();
    RegUserDTO availableUser(String userName);
}
