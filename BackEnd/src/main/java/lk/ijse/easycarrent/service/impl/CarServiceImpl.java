package lk.ijse.easycarrent.service.impl;

import lk.ijse.easycarrent.dto.CarDTO;
import lk.ijse.easycarrent.dto.CustomDTO;
import lk.ijse.easycarrent.embeded.Image;
import lk.ijse.easycarrent.entity.Car;
import lk.ijse.easycarrent.repo.CarRepo;
import lk.ijse.easycarrent.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        Car car = new Car(dto.getCar_Id(), dto.getName(), dto.getBrand(), dto.getType(), new Image(), dto.getNumber_Of_Passengers(), dto.getTransmission_Type(), dto.getFuel_Type(), dto.getRent_Duration_Price(), dto.getPrice_Extra_KM(), dto.getRegistration_Number(), dto.getFree_Mileage(), dto.getColor(), dto.getVehicleAvailabilityType());
        if (repo.existsById(dto.getCar_Id())) {
            throw new RuntimeException("Car Already Exists..! Please Enter New ID..!");
        }

        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getImage().getFront_View().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getImage().getFront_View().getOriginalFilename()));
            dto.getImage().getBack_View().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getImage().getBack_View().getOriginalFilename()));
            dto.getImage().getSide_View().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getImage().getSide_View().getOriginalFilename()));
            dto.getImage().getInterior().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getImage().getInterior().getOriginalFilename()));

            car.getImage().setFront_View("uploads/"+dto.getImage().getFront_View().getOriginalFilename());
            car.getImage().setBack_View("uploads/"+dto.getImage().getBack_View().getOriginalFilename());
            car.getImage().setSide_View("uploads/"+dto.getImage().getSide_View().getOriginalFilename());
            car.getImage().setInterior("uploads/"+dto.getImage().getInterior().getOriginalFilename());

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        repo.save(car);
    }

    @Override
    public void updateCar(CarDTO dto) {
        Car car = new Car(dto.getCar_Id(), dto.getName(), dto.getBrand(), dto.getType(), new Image(), dto.getNumber_Of_Passengers(), dto.getTransmission_Type(), dto.getFuel_Type(), dto.getRent_Duration_Price(), dto.getPrice_Extra_KM(), dto.getRegistration_Number(), dto.getFree_Mileage(), dto.getColor(), dto.getVehicleAvailabilityType());
        if (!repo.existsById(dto.getCar_Id())) {
            throw new RuntimeException("Car Not Exist. Please enter Valid id..!");
        }
        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getImage().getFront_View().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getImage().getFront_View().getOriginalFilename()));
            dto.getImage().getBack_View().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getImage().getBack_View().getOriginalFilename()));
            dto.getImage().getSide_View().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getImage().getSide_View().getOriginalFilename()));
            dto.getImage().getInterior().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getImage().getInterior().getOriginalFilename()));

            car.getImage().setFront_View("uploads/"+dto.getImage().getFront_View().getOriginalFilename());
            car.getImage().setBack_View("uploads/"+dto.getImage().getBack_View().getOriginalFilename());
            car.getImage().setSide_View("uploads/"+dto.getImage().getSide_View().getOriginalFilename());
            car.getImage().setInterior("uploads/"+dto.getImage().getInterior().getOriginalFilename());

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        repo.save(car);
    }

    @Override
    public void deleteCar(String carId) {
        if (!repo.existsById(carId)) {
            throw new RuntimeException("Wrong ID..! Please Enter valid ID..!");
        }
        repo.deleteById(carId);
    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<Car>>() {
        }.getType());
    }

    @Override
    public CustomDTO carIdGenerate() {
        return new CustomDTO(repo.getLastIndex());
    }

    @Override
    public Car searchCarId(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Wrong ID..! Please Enter Valid ID..!");
        }
        return mapper.map(repo.findById(id).get(), Car.class);
    }

    @Override
    public CustomDTO getSumCar() {
        return new CustomDTO(repo.getSumCar());
    }

    @Override
    public CustomDTO getSumAvailableCar() {
        return new CustomDTO(repo.getSumAvailableCar());
    }

    @Override
    public CustomDTO getSumReservedCar() {
        return new CustomDTO(repo.getSumReservedCar());
    }

    @Override
    public CustomDTO getSumMaintainCar() {
        return new CustomDTO(repo.getSumMaintainCar());
    }

    @Override
    public CustomDTO getSumUnderMaintainCar() {
        return new CustomDTO(repo.getSumUnderMaintainCar());
    }

    @Override
    public ArrayList<CarDTO> getFilerData(String type,String fuelType) {
        return mapper.map(repo.filterCar(type,fuelType), new TypeToken<ArrayList<Car>>() {
        }.getType());
    }

    @Override
    public ArrayList<CarDTO> filterCarDetails(String name, String fuel_Type, String type, String transmission_Type) {
        return mapper.map(repo.filterCarDetails(name,fuel_Type,type,transmission_Type), new TypeToken<ArrayList<Car>>() {
        }.getType());
    }
}
