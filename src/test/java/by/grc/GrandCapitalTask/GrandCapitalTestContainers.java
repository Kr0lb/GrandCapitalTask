package by.grc.GrandCapitalTask;

import by.grc.GrandCapitalTask.dtos.EmailDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class GrandCapitalTestContainers {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${security.jwt.expiration-time}")
    private long jwtExpiration;

    public static final PostgreSQLContainer<?> postgresContainer =
            new PostgreSQLContainer<>("postgres:13.3")
                    .withDatabaseName("testdb")
                    .withUsername("user")
                    .withPassword("password");

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        postgresContainer.start();
    }

    @Test
    public void testGetAccount() throws Exception {
        String token = generateToken("jons@gmail.com");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/search?page=0&size=10&name=Jons")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andReturn();

        // Проверка ответа
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    public void testAddEmail() throws Exception {
        String token = generateToken("jons@gmail.com");

        EmailDto emailDto = new EmailDto();
        emailDto.setEmail("jons1@gmail.com");

        mockMvc.perform(MockMvcRequestBuilders.post("/email/add", emailDto)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(emailDto)).header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }

//    @Test
//    public void testCreateAccount() throws Exception {
//        String accountJson = "{\"balance\":1000.0}";
//
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/accounts")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(accountJson))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andReturn();
//
//        String response = result.getResponse().getContentAsString();
//        assertEquals("{\"balance\":1000.0}", result.getResponse());
//    }

    @AfterEach
    public void tearDown() {
        postgresContainer.stop();
    }

    private String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
