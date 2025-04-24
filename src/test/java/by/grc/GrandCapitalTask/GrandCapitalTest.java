package by.grc.GrandCapitalTask;


import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class GrandCapitalTest {

    @Test
    @PostConstruct
    public void init() {

        System.out.println("gjfdgjdf");
    }
}
