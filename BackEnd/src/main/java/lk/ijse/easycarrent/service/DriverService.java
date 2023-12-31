package lk.ijse.easycarrent.service;

import lk.ijse.easycarrent.dto.CustomDTO;
import lk.ijse.easycarrent.dto.DriverDTO;
import lk.ijse.easycarrent.entity.Driver;

import java.util.ArrayList;

public interface DriverService {
   public void saveDriver(DriverDTO dto);
   public void updateDriver(DriverDTO dto);
   public void deleteDriver(String reg_ID);
    ArrayList<DriverDTO> getAllDrivers();
    ArrayList<DriverDTO> getAllAvailableDrivers();
    CustomDTO userIdGenerate();
    CustomDTO getSumAvailableDriver();
    CustomDTO getSumUnavailableDriver();
    Driver searchDriverId(String id);
    CustomDTO getSumDriver();
}
