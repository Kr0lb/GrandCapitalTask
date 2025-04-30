package by.grc.GrandCapitalTask.controllers;

import by.grc.GrandCapitalTask.models.User;
import by.grc.GrandCapitalTask.services.AuthenticationService;
import by.grc.GrandCapitalTask.configaration.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
@Tag(name = "AuthenticationController", description = "контроллер для авторизации")
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @Operation(summary = "Авторизация", description = "авторизует пользователя")
    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestParam String username, @RequestParam String password) {
        User authenticatedUser = authenticationService.authenticate(username, password);

        return ResponseEntity.ok(jwtService.generateToken(authenticatedUser));
    }
}
