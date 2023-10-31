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

        Reg_User regUser = new Reg_User(dto.getUserId(), dto.getName(), dto.getContactNo(), dto.getAddress(), dto.getEmail(), dto.getNic(), dto.getLicenseNo(), "", "", new User(dto.getUser().getUserId(), dto.getUser().getRoleType(), dto.getUser().getUserName(), dto.getUser().getPassword()));
        if (repo.existsById(dto.getUserId()))
            throw new RuntimeException("User Already Exist. Please Enter New ID..!");

        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getNicImg().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getNicImg().getOriginalFilename()));
            dto.getLicenseImg().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getLicenseImg().getOriginalFilename()));

            regUser.setNicImg("uploads/" + dto.getNicImg().getOriginalFilename());
            regUser.setLicenseImg("uploads/" + dto.getLicenseImg().getOriginalFilename());


        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(regUser);
        repo.save(regUser);

    }

    @Override
    public void updateUser(RegUserDTO dto) {

        Reg_User regUser = new Reg_User(dto.getUserId(), dto.getName(), dto.getContactNo(), dto.getAddress(), dto.getEmail(), dto.getNic(), dto.getLicenseNo(), "", "", new User(dto.getUser().getUserId(), dto.getUser().getRoleType(), dto.getUser().getUserName(), dto.getUser().getPassword()));
        if (!repo.existsById(dto.getUserId())) {
            throw new RuntimeException("User Not Exist. Please Enter Valid ID..!");
        }

        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getNicImg().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getNicImg().getOriginalFilename()));
            dto.getLicenseImg().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getLicenseImg().getOriginalFilename()));

            regUser.setNicImg("uploads/" + dto.getNicImg().getOriginalFilename());
            regUser.setLicenseImg("uploads/" + dto.getLicenseImg().getOriginalFilename());


        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(regUser);
        regUser.getUser().setRoleType(RoleType.REGISTERED_USER);
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
