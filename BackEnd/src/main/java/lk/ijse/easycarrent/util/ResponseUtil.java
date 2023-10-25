package lk.ijse.easycarrent.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResponseUtil {
    private String state;
    private String message;
    private Object data;
}
