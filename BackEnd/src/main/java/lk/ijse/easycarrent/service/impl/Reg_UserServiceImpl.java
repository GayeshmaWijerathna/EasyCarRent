package lk.ijse.easycarrent.service.impl;

import lk.ijse.easycarrent.dto.CustomDTO;
import lk.ijse.easycarrent.dto.RegUserDTO;
import lk.ijse.easycarrent.entity.Reg_User;
import lk.ijse.easycarrent.entity.User;
import lk.ijse.easycarrent.enums.RoleType;
import lk.ijse.easycarrent.repo.Reg_UserRepo;
import lk.ijse.easycarrent.service.Reg_UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;


@Service
@Transactional
public class Reg_UserServiceImpl implements Reg_UserService {
    @Autowired
    private Reg_UserRepo repo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveUser(RegUserDTO dto) {

        Reg_User regUser = new Reg_User(dto.getUser_Id(), dto.getName(), dto.getContact_No(), dto.getAddress(), dto.getEmail(), dto.getNic(), dto.getLicense_No(), "", "", new User(dto.getUser().getUser_Id(), dto.getUser().getRole_Type(), dto.getUser().getUser_Name(), dto.getUser().getPassword()));
        if (repo.existsById(dto.getUser_Id()))
            throw new RuntimeException("User Already Exist. Please Enter New ID..!");

        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getNic_Img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getNic_Img().getOriginalFilename()));
            dto.getLicense_Img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getLicense_Img().getOriginalFilename()));

            regUser.setNic_Img("uploads/" + dto.getNic_Img().getOriginalFilename());
            regUser.setLicense_Img("uploads/" + dto.getLicense_Img().getOriginalFilename());


        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(regUser);
        repo.save(regUser);

    }

    @Override
    public void updateUser(RegUserDTO dto) {

        Reg_User regUser = new Reg_User(dto.getUser_Id(), dto.getName(), dto.getContact_No(), dto.getAddress(), dto.getEmail(), dto.getNic(), dto.getLicense_No(), "", "", new User(dto.getUser().getUser_Id(), dto.getUser().getRole_Type(), dto.getUser().getUser_Name(), dto.getUser().getPassword()));
        if (!repo.existsById(dto.getUser_Id())) {
            throw new RuntimeException("User Not Exist. Please Enter Valid ID..!");
        }

        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getNic_Img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getNic_Img().getOriginalFilename()));
            dto.getLicense_Img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getLicense_Img().getOriginalFilename()));

            regUser.setNic_Img("uploads/" + dto.getNic_Img().getOriginalFilename());
            regUser.setLicense_Img("uploads/" + dto.getLicense_Img().getOriginalFilename());


        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(regUser);
        regUser.getUser().setRole_Type(RoleType.REGISTERED_USER);
        repo.save(regUser);

    }

    @Override
    public void deleteUser(String regID) {
        if (!repo.existsById(regID)) {
            throw new RuntimeException("Wrong ID..Please Enter valid ID..!");
        }
        repo.deleteById(regID);
    }

    @Override
    public ArrayList<RegUserDTO> getAllUser() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<Reg_User>>() {
        }.getType());
    }

    @Override
    public CustomDTO userIdGenerate() {
        return new CustomDTO(repo.getLastIndex());
    }

    @Override
    public Reg_User searchUserId(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Wrong ID. Please Enter Valid ID..!");
        }
        System.out.println(id);
        return mapper.map(repo.findById(id).get(), Reg_User.class);
    }

    @Override
    public CustomDTO getSumUser() {
        return new CustomDTO(repo.getSumUsers());
    }

    @Override
    public RegUserDTO availableUser(String userName) {
        return repo.availableUser(userName);
    }
}
