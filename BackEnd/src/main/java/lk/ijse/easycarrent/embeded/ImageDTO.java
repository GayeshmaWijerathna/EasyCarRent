package lk.ijse.easycarrent.embeded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ImageDTO {
    private MultipartFile frontView;
    private MultipartFile backView;
    private MultipartFile sideView;
    private MultipartFile interior;
}
