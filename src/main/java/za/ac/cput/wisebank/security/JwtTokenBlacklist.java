package za.ac.cput.wisebank.security;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class JwtTokenBlacklist {
    // token -> expiry epoch millis
    private final Map<String, Long> blacklist = new ConcurrentHashMap<>();

    public void blacklist(String token, long expiresAtMillis) {
        if (token == null || token.isBlank()) return;
        blacklist.put(token, expiresAtMillis);
    }

    public boolean isBlacklisted(String token) {
        if (token == null) return false;
        Long exp = blacklist.get(token);
        if (exp == null) return false;
        long now = System.currentTimeMillis();
        if (exp <= now) {
            // cleanup expired blacklist entry
            blacklist.remove(token);
            return false;
        }
        return true;
    }
}
//guys check if this page will show up in the final project
//53