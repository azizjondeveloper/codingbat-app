package uz.pdp.codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.codingbat.config.SecurityConfig;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.UserDTO;
import uz.pdp.codingbat.repository.UserRepository;
import uz.pdp.codingbat.service.UserService;

import javax.servlet.FilterChain;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserControllerImpl implements UserController{

    private final UserService userService;


    @Override
    public ApiResult add(UserDTO userDTO) {
    return userService.add(userDTO);

    }

    @Override
    public List<UserDTO> getAll() {
        return null;
    }

    @Override
    public UserDTO get(String username) {
        return null;
    }

    @Override
    public ApiResult edit(String username, UserDTO userDTO) {

//        UserDetails userDetails = securityConfig.userDetailsService().loadUserByUsername(username);
//
//        securityConfig.userDetailsService().changePassword(userDetails.getPassword(),userDTO.getPassword());
        return null;
    }

    @Override
    public ApiResult delete(String username) {
        return null;
    }
}
