package lk.ijse.easycarrent.service.impl;

import lk.ijse.easycarrent.dto.AdminDTO;
import lk.ijse.easycarrent.entity.Admin;
import lk.ijse.easycarrent.repo.AdminRepo;
import lk.ijse.easycarrent.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveAdmin(AdminDTO dto) {
        if (repo.existsById(dto.getUserId())) {
            throw new RuntimeException("Admin Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(dto, Admin.class));
    }

    @Override
    public void updateAdmin(AdminDTO dto) {
        if (!repo.existsById(dto.getUserId())) {
            throw new RuntimeException("Admin Not Exist. Please enter Valid id..!");
        }
        repo.save(mapper.map(dto, Admin.class));
    }

    @Override
    public void deleteAdmin(String regID) {
        if (!repo.existsById(regID)) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        repo.deleteById(regID);
    }

    @Override
    public ArrayList<AdminDTO> getAllAdmin() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<Admin>>() {
        }.getType());
    }
}