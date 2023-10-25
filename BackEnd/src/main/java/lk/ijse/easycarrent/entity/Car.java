package lk.ijse.easycarrent.entity;

import lk.ijse.easycarrent.embeded.Image;
import lk.ijse.easycarrent.embeded.Rate;
import lk.ijse.easycarrent.enums.AvailabilityType;
import lk.ijse.easycarrent.enums.CarType;
import lk.ijse.easycarrent.enums.FuelType;
import lk.ijse.easycarrent.enums.Transmission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
   private String carId;
   private String name;
   private String brand;
   @Enumerated(EnumType.STRING)
   private CarType type;
   @Embedded
   private Image image;
   private int noOfPassengers;
   @Enumerated(EnumType.STRING)
   private Transmission transmissionType;
   @Enumerated(EnumType.STRING)
   private FuelType fuelType;
   @Embedded
   private Rate rentDurationPrice;
   private double priceExtraKM;
   private String registrationNumber;
   private double freeMileage;
   private String color;
   @Enumerated(EnumType.STRING)
   private AvailabilityType vehicleAvailabilityType;

}
