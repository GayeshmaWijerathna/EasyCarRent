package lk.ijse.easycarrent.embeded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Name {
    String firstName;
    String lastName;
}
