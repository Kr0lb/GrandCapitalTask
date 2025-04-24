package by.grc.GrandCapitalTask.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link by.grc.GrandCapitalTask.models.EmailData}
 */
@Value
public class EmailDataDto implements Serializable {
    Long ID;
    UserDto user;
    String email;
}