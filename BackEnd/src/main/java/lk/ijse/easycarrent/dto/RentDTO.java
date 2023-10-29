package lk.ijse.easycarrent.dto;


import lk.ijse.easycarrent.enums.DriverType;
import lk.ijse.easycarrent.enums.RentRequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RentDTO {

    private String rentID;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    private LocalTime returnTime;
    private DriverType requestType;
    private RentRequestType rentType;
    private String location;
    private RegUserDTO regUser;

    private List<RentDetailsDTO> rentDetails;

}
