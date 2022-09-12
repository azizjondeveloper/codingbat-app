package uz.pdp.codingbat.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.User;
import uz.pdp.codingbat.exception.DataNotfoundException;
import uz.pdp.codingbat.exception.InputDataExistsException;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SignDTO;
import uz.pdp.codingbat.payload.TokenDTO;
import uz.pdp.codingbat.repository.UserRepository;

import java.util.Date;
import java.util.UUID;

@Service
public class AuthService implements UserDetailsService {


    @Value("${jwt.access.key}")
    private String accessTokenKey;

    @Value("${jwt.access.expirationTime}")
    private Long accessTokenExpirationTime;

    @Value("${jwt.refresh.key}")
    private String refreshTokenKey;

    @Value("${jwt.refresh.expirationTime}")
    private Long refreshTokenExpirationTime;


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    public AuthService(UserRepository userRepository,
                       @Lazy PasswordEncoder passwordEncoder,
                       @Lazy AuthenticationManager authenticationManager,
                       EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.emailService = emailService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("Bunday %s topilmadi", username)));
    }

    public ApiResult<String> register(SignDTO signDTO) {

        //BUNDAY EMAIL BORMI?
        if (userRepository.existsByUsername(signDTO.getUsername()))
            throw new InputDataExistsException("Bunday email mavjud");

        User user = new User(
                signDTO.getUsername(),
                passwordEncoder.encode(signDTO.getPassword()));


        UUID emailCode = UUID.randomUUID();

        user.setEmailCode(emailCode);

        userRepository.save(user);

        new Thread(() -> emailService.sendEmailVerificationCode(user.getUsername(), emailCode)).start();

        return ApiResult.successResponse("OK");
    }

    public ApiResult<TokenDTO> signIn(SignDTO signDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signDTO.getUsername(),
                        signDTO.getPassword()
                )
        );

        User user = (User) authentication.getPrincipal();

        String accessToken = generateToken(user.getUsername(), accessTokenKey, accessTokenExpirationTime);

        String refreshToken = generateToken(user.getUsername(), refreshTokenKey, refreshTokenExpirationTime);

        TokenDTO tokenDTO = TokenDTO.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

        return ApiResult.successResponse(tokenDTO);
    }

    public ApiResult<String> verificationEmail(UUID code) {

        User user = userRepository.findByEmailCode(code)
                .orElseThrow(() -> new DataNotfoundException("Bunday code mavjud emas"));

        user.setEmailCode(null);
        user.setEnabled(true);
        userRepository.save(user);

        return ApiResult.successResponse("Muvaffaqiyatli activ qilindi");
    }

    private String generateToken(String username,
                                 String tokenKey,
                                 Long expirationTime) {
        return Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, tokenKey)
                .compact();
    }
}
