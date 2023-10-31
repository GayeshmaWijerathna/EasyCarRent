package lk.ijse.easycarrent.service.impl;

import lk.ijse.easycarrent.dto.UserDTO;
import lk.ijse.easycarrent.repo.UserRepo;
import lk.ijse.easycarrent.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public ArrayList<UserDTO> getAllRegUsers() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<UserDTO>>() {
        }.getType());
    }

    @Override
    public UserDTO getRegUsers(String username, String password) {
        return mapper.map(repo.findUserByUserNameAndPassword(username, password), UserDTO.class);
    }
}
