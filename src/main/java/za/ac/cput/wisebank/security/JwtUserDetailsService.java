package za.ac.cput.wisebank.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.wisebank.repository.UserRepository;

import java.util.Collections;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public JwtUserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Try email first, then id
        za.ac.cput.wisebank.domain.User appUser = userRepository.findByEmail(username).orElse(null);
        if (appUser == null) {
            appUser = userRepository.findById(username).orElse(null);
        }
        if (appUser == null) {
            throw new UsernameNotFoundException("User not found with username/email: " + username);
        }

        // Seamless password migration: if stored password isn't BCrypt, encode and persist
        String stored = appUser.getPassword();
        if (stored != null && !isPasswordEncoded(stored)) {
            String encoded = passwordEncoder.encode(stored);
            appUser.setPassword(encoded);
            userRepository.save(appUser);
            stored = encoded;
        }

        String loginName = appUser.getEmail() != null ? appUser.getEmail() : appUser.getIdNumber();

        return User.withUsername(loginName)
                .password(stored)
                .authorities(Collections.emptyList())
                .build();
    }

    private boolean isPasswordEncoded(String password) {
        return password.startsWith("$2a$") || password.startsWith("$2b$") || password.startsWith("$2y$");
    }
}
