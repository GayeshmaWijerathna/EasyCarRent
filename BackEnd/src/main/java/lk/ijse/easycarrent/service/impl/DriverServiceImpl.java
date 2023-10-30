package lk.ijse.easycarrent.service.impl;

import lk.ijse.easycarrent.dto.CustomDTO;
import lk.ijse.easycarrent.dto.DriverDTO;
import lk.ijse.easycarrent.entity.Driver;
import lk.ijse.easycarrent.entity.User;
import lk.ijse.easycarrent.repo.DriverRepo;
import lk.ijse.easycarrent.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Transactional
@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {

        Driver driver = new Driver(dto.getUserId(), dto.getName(), dto.getContactNo(), dto.getAddress(), dto.getEmail(), dto.getNicNo(), dto.getLicenseNo(), "", dto.getDriverAvailability(), new User(dto.getUser().getUserId(), dto.getUser().getRoleType(), dto.getUser().getUserName(), dto.getUser().getPassword()));
        System.out.println(driver);
        if (repo.existsById(dto.getUserId()))
            throw new RuntimeException("Driver Already Exist. Please enter another id..!");

        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getLicenseImg().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getLicenseImg().getOriginalFilename()));

            driver.setLicenseImg("uploads/" + dto.getLicenseImg().getOriginalFilename());

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver);
        repo.save(driver);

    }

    @Override
    public void updateDriver(DriverDTO dto) {

        Driver driver = new Driver(dto.getUserId(), dto.getName(), dto.getContactNo(), dto.getAddress(), dto.getEmail(), dto.getNicNo(), dto.getLicenseNo(), "", dto.getDriverAvailability(), new User(dto.getUser().getUserId(), dto.getUser().getRoleType(), dto.getUser().getUserName(), dto.getUser().getPassword()));
        System.out.println(driver);
        if (!repo.existsById(dto.getUserId())) {
            throw new RuntimeException("Driver Not Exist. Please enter Valid id..!");
        }

        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getLicenseImg().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getLicenseImg().getOriginalFilename()));

            driver.setLicenseImg("uploads/" + dto.getLicenseImg().getOriginalFilename());

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver);
        repo.save(driver);

    }

    @Override
    public void deleteDriver(String driverID) {
        if (!repo.existsById(driverID)) {
            throw new RuntimeException("Wrong ID..Please Enter Valid ID..!");
        }
        repo.deleteById(driverID);
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<Driver>>() {
        }.getType());
    }

    @Override
    public ArrayList<DriverDTO> getAllAvailableDrivers() {
        return mapper.map(repo.availableDrivers(), new TypeToken<ArrayList<Driver>>() {
        }.getType());
    }

    @Override
    public CustomDTO userIdGenerate() {
        return new CustomDTO(repo.getLastIndex());
    }

    @Override
    public CustomDTO getSumAvailableDriver() {
        return new CustomDTO(repo.getSumAvailableDriver());
    }

    @Override
    public CustomDTO getSumUnavailableDriver() {
        return new CustomDTO(repo.getSumUnavailableDriver());
    }

    @Override
    public Driver searchDriverId(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Wrong ID..Please Enter Valid ID..!");
        }
        return mapper.map(repo.findById(id).get(), Driver.class);
    }

    @Override
    public CustomDTO getSumDriver() {
        return new CustomDTO(repo.getSumDriver());
    }
}
