package by.grc.GrandCapitalTask.dtos;

import by.grc.GrandCapitalTask.models.Account;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Account}
 */
@Value
public class AccountDto implements Serializable {
    Long ID;
    UserDto user;
    Double balance;
}