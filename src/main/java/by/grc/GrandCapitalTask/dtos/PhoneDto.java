package by.grc.GrandCapitalTask.dtos;

import by.grc.GrandCapitalTask.models.Phone;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Phone}
 */
@Value
public class PhoneDto implements Serializable {
    Long ID;
    UserDto user;
    String phone;
}