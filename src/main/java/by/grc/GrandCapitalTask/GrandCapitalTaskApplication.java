package by.grc.GrandCapitalTask;

import by.grc.GrandCapitalTask.models.User;
import by.grc.GrandCapitalTask.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.List;

@EnableScheduling
@SpringBootApplication
public class GrandCapitalTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrandCapitalTaskApplication.class, args);
    }
}
