package by.grc.GrandCapitalTask;

import by.grc.GrandCapitalTask.models.Account;
import by.grc.GrandCapitalTask.models.Email;
import by.grc.GrandCapitalTask.models.Phone;
import by.grc.GrandCapitalTask.models.User;
import by.grc.GrandCapitalTask.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

@EnableScheduling
@SpringBootApplication
public class GrandCapitalTaskApplication {

    @Autowired
    private UserService userService;
    @Autowired
    private DepositService depositService;
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(GrandCapitalTaskApplication.class, args);
    }
}
