package by.grc.GrandCapitalTask.dtos;

import by.grc.GrandCapitalTask.models.Email;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Email}
 */
@Value
public class EmailDto implements Serializable {
    Long ID;
    UserDto user;
    String email;
}