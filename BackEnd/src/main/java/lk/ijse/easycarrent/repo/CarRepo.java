package lk.ijse.easycarrent.repo;

import lk.ijse.easycarrent.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface CarRepo extends JpaRepository<Car, String> {
    @Query(value = "SELECT carId FROM Car ORDER BY carId DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT COUNT(carId) FROM Car", nativeQuery = true)
    int getSumCar();

    @Query(value = "SELECT COUNT(carId) FROM Car WHERE vehicleAvailabilityType='AVAILABLE';", nativeQuery = true)
    int getSumAvailableCar();

    @Query(value = "SELECT COUNT(carId) FROM Car WHERE vehicleAvailabilityType='UNAVAILABLE';", nativeQuery = true)
    int getSumReservedCar();

    @Query(value = "SELECT COUNT(carId) FROM Car WHERE vehicleAvailabilityType='MAINTAIN';", nativeQuery = true)
    int getSumMaintainCar();

    @Query(value = "SELECT COUNT(car_Id) FROM Car WHERE vehicleAvailabilityType='UNDERMAINTAIN';", nativeQuery = true)
    int getSumUnderMaintainCar();

    @Query(value = "SELECT * FROM Car WHERE type =?1 and fuelType=?2 and vehicleAvailabilityType='AVAILABLE' ", nativeQuery = true)
    ArrayList<Car> filterCar(String type, String fuel_Type);

    @Query(value = "SELECT * FROM Car WHERE name=?1 or fuelType=?2 and type=?3 and transmissionType=?4 and vehicleAvailabilityType='AVAILABLE'", nativeQuery = true)
    ArrayList<Car> filterCarDetails(String name, String fuelType,String type, String transmissionType);
}
