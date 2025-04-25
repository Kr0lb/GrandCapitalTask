package by.grc.GrandCapitalTask.controllers;

import by.grc.GrandCapitalTask.services.AccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PutMapping("/transfer")
    public void transferToUser(@RequestParam Long clientId, @Pattern(regexp = "^\\d*.\\d\\d") @RequestParam Double price) {
        this.accountService.transfer(clientId, price);
    }
}
