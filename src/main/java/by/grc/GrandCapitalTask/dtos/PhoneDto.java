package by.grc.GrandCapitalTask.dtos;

import by.grc.GrandCapitalTask.models.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Phone}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDto implements Serializable {
    Long id;
//    UserDto user;
    String phone;
}