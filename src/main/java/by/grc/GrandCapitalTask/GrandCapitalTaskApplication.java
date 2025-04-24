package by.grc.GrandCapitalTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GrandCapitalTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrandCapitalTaskApplication.class, args);
    }
}
