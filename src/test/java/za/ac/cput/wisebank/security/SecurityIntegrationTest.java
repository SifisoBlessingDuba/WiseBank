package za.ac.cput.wisebank.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.dto.AuthRequest;
import za.ac.cput.wisebank.dto.AuthResponse;
import za.ac.cput.wisebank.service.UserService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class SecurityIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate rest;

    @Autowired
    private UserService userService;

    private String baseUrl;

    @BeforeEach
    void setUp() {
        baseUrl = "http://localhost:" + port;
        // Seed a user with raw password (service will encode)
        User user = new User.Builder()
                .setIdNumber("ID12345")
                .setEmail("test@example.com")
                .setPassword("password123")
                .setFirstName("Test")
                .setLastName("User")
                .build();
        userService.save(user);
    }

    @Test
    void protectedEndpoint_requiresJwt_and_allowsWithJwt() {
        // 1) Without token -> expect 401 on a protected endpoint
        ResponseEntity<String> noToken = rest.getForEntity(baseUrl + "/Loan/all-loans", String.class);
        assertThat(noToken.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);

        // 2) Login to get JWT using email
        AuthRequest login = new AuthRequest("test@example.com", "password123");
        ResponseEntity<AuthResponse> loginRes = rest.postForEntity(baseUrl + "/auth/login", login, AuthResponse.class);
        assertThat(loginRes.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(loginRes.getBody()).isNotNull();
        String token = loginRes.getBody().getToken();
        assertThat(token).isNotBlank();

        // 3) Call protected endpoint with Bearer token -> expect 200 (even if body may be empty array)
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<String> withToken = rest.exchange(baseUrl + "/Loan/all-loans", HttpMethod.GET, entity, String.class);
        assertThat(withToken.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void login_with_idNumber_allows_access_with_jwt() {
        // Login using idNumber instead of email
        AuthRequest login = new AuthRequest("ID12345", "password123");
        ResponseEntity<AuthResponse> loginRes = rest.postForEntity(baseUrl + "/auth/login", login, AuthResponse.class);
        assertThat(loginRes.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(loginRes.getBody()).isNotNull();
        String token = loginRes.getBody().getToken();
        assertThat(token).isNotBlank();

        // Use token to access protected endpoint
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<String> withToken = rest.exchange(baseUrl + "/Loan/all-loans", HttpMethod.GET, entity, String.class);
        assertThat(withToken.getStatusCode()).isEqualTo(HttpStatus.OK);
}
}