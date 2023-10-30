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
     if (repo.existsById(dto.getUserId())){
         throw new RuntimeException("Admin Already Exists!! Please Add New ID");
     }
     repo.save(mapper.map(dto, Admin.class));
    }

    @Override
    public void updateAdmin(AdminDTO dto) {
    if (!repo.existsById(dto.getUserId())){
        throw new RuntimeException("ID Not in the System. Please Enter Valid ID !");
    }
        repo.save(mapper.map(dto, Admin.class));
    }

    @Override
    public void deleteAdmin(String reg_ID) {
        if (!repo.existsById(reg_ID)){
            throw new RuntimeException("Wrong ID.. Please Check Again..!");
        }
        repo.deleteById(reg_ID);
    }

    @Override
    public ArrayList<AdminDTO> getAllAdmin() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<Admin>>(){
        }.getType());
    }
}
