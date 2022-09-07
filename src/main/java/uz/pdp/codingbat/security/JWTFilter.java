package uz.pdp.codingbat.security;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.pdp.codingbat.entity.User;
import uz.pdp.codingbat.repository.UserRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    @Value("${jwt.key}")
    private String TOKEN_KEY;

    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        setSecurityContext(request);
        filterChain.doFilter(request, response);
    }

    private void setSecurityContext(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization == null)
            return;

        String token = authorization.substring(6).trim();

        String username = "";
        try {
            username = Jwts
                    .parser()
                    .setSigningKey(TOKEN_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } finally {

        }

        User user = userRepository.findByUsername(username).orElseThrow(RuntimeException::new);

        if (!user.isAccountNonExpired()
                || !user.isAccountNonLocked()
                || !user.isCredentialsNonExpired()
                || !user.isEnabled())
            return;

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        user.getAuthorities()
                )
        );


    }
}
