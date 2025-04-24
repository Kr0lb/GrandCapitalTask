package by.grc.GrandCapitalTask.dtos;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link by.grc.GrandCapitalTask.models.User}
 */
@Value
public class UserDto implements Serializable {
    Long ID;
    String name;
    LocalDate dateOfBirth;
    String password;
}