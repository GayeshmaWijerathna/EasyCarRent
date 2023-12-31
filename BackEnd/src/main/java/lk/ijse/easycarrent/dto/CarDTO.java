package lk.ijse.easycarrent.dto;


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
    private String car_Id;

    private String name;
    private String brand;
    private CarType type;
    private ImageDTO image;
    private int number_Of_Passengers;
    private Transmission transmission_Type;
    private FuelType fuel_Type;
    private Rate rent_Duration_Price;
    private double price_Extra_KM;
    private String registration_Number;
    private double free_Mileage;
    private String color;
    private AvailabilityType vehicleAvailabilityType;
}
