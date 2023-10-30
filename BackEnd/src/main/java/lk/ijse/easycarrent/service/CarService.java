package lk.ijse.easycarrent.service;

import lk.ijse.easycarrent.dto.CarDTO;
import lk.ijse.easycarrent.dto.CustomDTO;
import lk.ijse.easycarrent.entity.Car;

import java.util.ArrayList;

public interface CarService {
    public void saveCar(CarDTO dto);
    public void updateCar(CarDTO dto);
    public void deleteCar(String carId);

    ArrayList<CarDTO> getAllCars();
    CustomDTO carIdGenerate();
    Car searchCarId(String id);
    CustomDTO getSumCar();
    CustomDTO getSumAvailableCar();
    CustomDTO getSumReservedCar();
    CustomDTO getSumMaintainCar();
    CustomDTO getSumUnderMaintainCar();
    ArrayList<CarDTO> getFilerData(String type,String fuelType);
    ArrayList<CarDTO> filterCarDetails(String name, String fuelType,String type, String transmissionType);


}
