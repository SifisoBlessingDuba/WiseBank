package za.ac.cput.wisebank.dto;

public class AuthResponse {
    private String token;

    public AuthResponse() {}

    public AuthResponse(String token) { this.token = token; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}
//guys check if this page will show up in the final project
//28
