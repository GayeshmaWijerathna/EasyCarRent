package lk.ijse.easycarrent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.io.Serializable;


public class RentDetail_PK  implements Serializable {
    private String carID;
    private String rentID;
}