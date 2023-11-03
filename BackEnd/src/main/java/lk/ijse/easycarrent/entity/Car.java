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
import lombok.ToString;

import javax.persistence.*;
import java.awt.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {
    @Id
   private String car_Id;
   private String name;
   private String brand;
   @Enumerated(EnumType.STRING)
   private CarType type;
   @Embedded
   private Image image;
   private int number_Of_Passengers;
   @Enumerated(EnumType.STRING)
   private Transmission transmission_Type;
   @Enumerated(EnumType.STRING)
   private FuelType fuel_Type;
   @Embedded
   private Rate rent_Duration_Price;
   private double price_Extra_KM;
   private String registration_Number;
   private double free_Mileage;
   private String color;
   @Enumerated(EnumType.STRING)
   private AvailabilityType vehicleAvailabilityType;

   public Car(String name, String brand, CarType type, Image image, int number_Of_Passengers, Transmission transmission_Type, FuelType fuel_Type, Rate rent_Duration_Price, double price_Extra_KM, String registration_Number, double free_Mileage, String color, AvailabilityType vehicleAvailabilityType) {
      this.name = name;
      this.brand = brand;
      this.type = type;
      this.image = image;
      this.number_Of_Passengers = number_Of_Passengers;
      this.transmission_Type = transmission_Type;
      this.fuel_Type = fuel_Type;
      this.rent_Duration_Price = rent_Duration_Price;
      this.price_Extra_KM = price_Extra_KM;
      this.registration_Number = registration_Number;
      this.free_Mileage = free_Mileage;
      this.color = color;
      this.vehicleAvailabilityType = vehicleAvailabilityType;
   }
}
