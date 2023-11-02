package lk.ijse.easycarrent.embeded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Image {
    private String front_View;
    private String back_View;
    private String side_View;
    private String interior;
}
