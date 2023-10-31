package lk.ijse.easycarrent.service;

import lk.ijse.easycarrent.dto.UserDTO;

import java.util.ArrayList;

public interface UserService {
    ArrayList<UserDTO> getAllRegUsers();

    UserDTO getRegUsers(String username,String password);
}
