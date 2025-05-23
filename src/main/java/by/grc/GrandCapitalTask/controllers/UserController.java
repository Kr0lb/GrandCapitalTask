package by.grc.GrandCapitalTask.controllers;

import by.grc.GrandCapitalTask.dtos.UserDto;
import by.grc.GrandCapitalTask.mapper.MapperImpl;
import by.grc.GrandCapitalTask.models.User;
import by.grc.GrandCapitalTask.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "UserController", description = "контроллер для работы с пользователями")
public class UserController {

    private final UserService userService;
    private final MapperImpl<User, UserDto> mapper;

    //Страницы начинаются с 0
    @Operation(summary = "Поиск", description = "Поиск пользователя по параметрам, с учетом пагинации")
    @GetMapping("/search")
    public List<UserDto> searchUser(@RequestParam(required = false) String dateOfBirth
            , @RequestParam(required = false) String phone, @RequestParam(required = false) String name
            , @RequestParam(required = false) String email, @RequestParam int page, @RequestParam int size, @AuthenticationPrincipal Jwt principal) {
        return this.mapper.toDtos(this.userService.searchUser(dateOfBirth, phone, name, email, page, size), UserDto.class);
    }
}
