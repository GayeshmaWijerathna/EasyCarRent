package lk.ijse.easycarrent.service;

import lk.ijse.easycarrent.dto.AdminDTO;

import java.util.ArrayList;

public interface AdminService {
    void saveAdmin(AdminDTO dto);
    void updateAdmin(AdminDTO dto);
    void deleteAdmin(String regID);
    ArrayList<AdminDTO> getAllAdmin();
}
