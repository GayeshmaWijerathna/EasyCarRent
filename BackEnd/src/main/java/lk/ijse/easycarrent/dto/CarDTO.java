package lk.ijse.easycarrent.dto;


import lk.ijse.easycarrent.embeded.ImageDTO;
import lk.ijse.easycarrent.embeded.Rate;
import lk.ijse.easycarrent.enums.AvailabilityType;
import lk.ijse.easycarrent.enums.CarType;
import lk.ijse.easycarrent.enums.FuelType;
import lk.ijse.easycarrent.enums.Transmission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDTO {
    private String carId;

    private String name;
    private String brand;
    private CarType type;
    private ImageDTO image;
    private int numberOfPassengers;
    private Transmission transmissionType;
    private FuelType fuelType;
    private Rate rentDurationPrice;
    private double priceExtraKM;
    private String registrationNumber;
    private double freeMileage;
    private String color;
    private AvailabilityType vehicleAvailabilityType;
}
