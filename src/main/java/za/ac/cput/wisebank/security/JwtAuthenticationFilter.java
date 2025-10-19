package za.ac.cput.wisebank.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenBlacklist tokenBlacklist;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        String jwt = null;
        String username = null;

        if (authHeader == null || authHeader.isBlank()) {
            logger.debug("[AUTH] No Authorization header present for " + request.getMethod() + " " + request.getRequestURI());
        } else {
            String value = authHeader.trim();
            logger.debug("[AUTH] Authorization header received (length=" + value.length() + ")");
            // Case-insensitive check for Bearer prefix
            if (value.regionMatches(true, 0, "Bearer ", 0, 7)) {
                jwt = value.substring(7).trim();

                // Ignore obvious non-token placeholders
                if (jwt.isEmpty() || "null".equalsIgnoreCase(jwt) || "undefined".equalsIgnoreCase(jwt)) {
                    logger.debug("[AUTH] Bearer token missing or placeholder value (ignored)");
                    jwt = null;
                }
            } else {
                logger.debug("[AUTH] Authorization header does not start with Bearer");
            }
        }

        // Check blacklist first
        if (jwt != null && tokenBlacklist.isBlacklisted(jwt)) {
            logger.debug("[AUTH] JWT is blacklisted (likely logged out); rejecting");
            jwt = null;
        }

        // Only attempt to parse if we have something that looks like a JWT (exactly 2 dots)
        if (jwt != null) {
            int dotCount = 0;
            for (int i = 0; i < jwt.length(); i++) {
                if (jwt.charAt(i) == '.') dotCount++;
            }
            if (dotCount == 2) {
                try {
                    username = jwtUtil.getUsernameFromToken(jwt);
                    try {
                        var claims = jwtUtil.parseClaims(jwt);
                        logger.debug("[AUTH] JWT parsed OK: sub=" + claims.getSubject() + ", exp=" + claims.getExpiration() + ", iat=" + claims.getIssuedAt());
                    } catch (Exception e) {
                        // already have username; ignore claim log failure
                    }
                } catch (io.jsonwebtoken.ExpiredJwtException ex) {
                    logger.debug("[AUTH] JWT expired: " + ex.getMessage());
                } catch (io.jsonwebtoken.security.SignatureException ex) {
                    logger.debug("[AUTH] JWT signature invalid: " + ex.getMessage());
                } catch (io.jsonwebtoken.JwtException ex) {
                    logger.debug("[AUTH] JWT invalid: " + ex.getClass().getSimpleName() + ": " + ex.getMessage());
                } catch (Exception ex) {
                    // Malformed/other; log at debug level to avoid noisy errors
                    logger.debug("[AUTH] JWT parse failed: " + ex.getClass().getSimpleName() + ": " + ex.getMessage());
                }
            } else {
                // Not a valid JWT structure; skip parsing
                logger.debug("[AUTH] Authorization header provided but token does not look like a JWT (expected 2 dots, found " + dotCount + ")");
            }
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (jwtUtil.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                logger.debug("[AUTH] Authentication set for user=" + username);
            } else {
                logger.debug("[AUTH] JWT failed validation against user details for user=" + username);
            }
        }

        filterChain.doFilter(request, response);
    }
}
