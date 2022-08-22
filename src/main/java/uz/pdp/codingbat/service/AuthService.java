package uz.pdp.codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.User;
import uz.pdp.codingbat.exception.InputDataExistsException;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SignDTO;
import uz.pdp.codingbat.repository.UserRepository;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ApiResult register(SignDTO signDTO) {

        //BUNDAY EMAIL BORMI?
        if (userRepository.existsByUsername(signDTO.getUsername()))
            throw new InputDataExistsException("Bunday email mavjud");

        User user = new User(
                signDTO.getUsername(),
                passwordEncoder.encode(signDTO.getPassword()));

        userRepository.save(user);
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

        return new ApiResult(true, "Oka keyingi darsda sizga token qyataraman");
    }
}
