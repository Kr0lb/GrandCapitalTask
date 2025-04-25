package by.grc.GrandCapitalTask.controllers;

import by.grc.GrandCapitalTask.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PutMapping("/transfer")
    public void transferToUser(@AuthenticationPrincipal Jwt principal) {
        this.accountService.transfer(null, null, null);
    }
}
