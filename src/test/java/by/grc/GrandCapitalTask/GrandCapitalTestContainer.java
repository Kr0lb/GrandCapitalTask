package by.grc.GrandCapitalTask;

import by.grc.GrandCapitalTask.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
public class GrandCapitalTestContainer {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private long jwtExpiration;

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("grand_capital")
            .withUsername("postgres")
            .withPassword("root");

    @DynamicPropertySource
    static void configure(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Test
    void testTransfer() throws Exception {
        String token = mockMvc.perform(MockMvcRequestBuilders.post("/auth/login?username=jons@gmail.com&password=12345678")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        mockMvc.perform(MockMvcRequestBuilders.put("/account/transfer?clientId=2&price=30.10")
                        .header("Authorization", "Bearer " + token))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //todo: может возникнуть ошибка из-за депозитов
        assertEquals(this.userService.getRepo().findById(1L).orElseThrow(Exception::new).getAccount().getBalance(), 70.00);
        assertEquals(this.userService.getRepo().findById(2L).orElseThrow(Exception::new).getAccount().getBalance(), 351.63);
    }

    @Test
    void testGetAccount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/search?page=0&size=10&name=Jons")
                        .header("Authorization", "Bearer " + generateToken("jons@gmail.com")))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(new SecretKeySpec(secretKey.getBytes(), "HmacSHA256"), SignatureAlgorithm.HS256)
                .compact();
    }
}
