package by.grc.GrandCapitalTask.dtos;

import by.grc.GrandCapitalTask.models.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Email}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto implements Serializable {
    Long id;
//    UserDto user;
    String email;
}