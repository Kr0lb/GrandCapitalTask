package by.grc.GrandCapitalTask.dtos;

import by.grc.GrandCapitalTask.models.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Account}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto implements Serializable {
    Long id;
    UserDto user;
    Double balance;
}