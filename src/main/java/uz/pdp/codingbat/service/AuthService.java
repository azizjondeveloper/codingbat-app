package uz.pdp.codingbat.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.User;
import uz.pdp.codingbat.exception.InputDataExistsException;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SignDTO;
import uz.pdp.codingbat.repository.UserRepository;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService {

    private static final int TOKEN_EXPIRATION_DURATION = 1000 * 60 * 60 * 24;
    @Value("${jwt.key}")
    private String TOKEN_KEY;


    private final UserRepository userRepository;
    private final MailSenderService mailSenderService;
    private final PasswordEncoder passwordEncoder;



    public ApiResult register(SignDTO signDTO) {

        //BUNDAY EMAIL BORMI?
        if (userRepository.existsByUsername(signDTO.getUsername()))
            throw new InputDataExistsException("Bunday email mavjud");

        User user = new User(
                signDTO.getUsername(),
                passwordEncoder.encode(signDTO.getPassword()));

        userRepository.save(user);

        mailSenderService.sendMessage("bu ko'd", user.getUsername());
        return new ApiResult(true, "OK");
    }

    public ApiResult signIn(SignDTO signDTO) {

        User user = userRepository.findByUsername(signDTO.getUsername())
                .orElseThrow(() -> new InputDataExistsException("Bunday emaillik user mavjud emas"));

        if (!user.isAccountNonExpired()
                || !user.isAccountNonLocked()
                || !user.isCredentialsNonExpired()
                || !user.isEnabled())
            throw new InputDataExistsException("Userning 4 ta boolean idan qaysidir false");

        if (!passwordEncoder.matches(signDTO.getPassword(), user.getPassword()))
            throw new InputDataExistsException("Parol yoki login xato");

        //TODO TOKEN QAYTAR

        String token = generateToken(user.getUsername());
        return new ApiResult(true, "Oka keyingi darsda sizga token qyataraman", token);
    }

    private String generateToken(String username) {
        String token = Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_DURATION))
                .signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
                .compact();
        return token;
    }
}
