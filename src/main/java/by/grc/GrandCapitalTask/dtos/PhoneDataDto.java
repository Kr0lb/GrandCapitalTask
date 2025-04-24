package by.grc.GrandCapitalTask.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link by.grc.GrandCapitalTask.models.PhoneData}
 */
@Value
public class PhoneDataDto implements Serializable {
    Long ID;
    UserDto user;
    String phone;
}