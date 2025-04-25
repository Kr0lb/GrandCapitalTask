package by.grc.GrandCapitalTask.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link by.grc.GrandCapitalTask.models.User}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    Long id;
    String name;
    @JsonFormat(pattern="dd.MM.yyyy")
    LocalDate dateOfBirth;
    List<EmailDto> emails;
    List<PhoneDto> phones;
}