package uz.pdp.codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.User;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.UserDTO;
import uz.pdp.codingbat.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;

    @Override
    public ApiResult<?> add(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
      return userRepository.findAll().stream().map(user -> new UserDTO(user.getUsername(), user.getPassword())).collect(Collectors.toList());
    }

    @Override
    public UserDTO get(String username) {
        return null;
    }

    @Override
    public ApiResult<?> edit(String username, UserDTO languageDTO) {
        return null;
    }

    @Override
    public ApiResult<?> delete(String username) {
        return null;
    }
}
