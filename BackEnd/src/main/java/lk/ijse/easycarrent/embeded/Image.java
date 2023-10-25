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
    private String frontView;
    private String backView;
    private String sideView;
    private String interior;
}
