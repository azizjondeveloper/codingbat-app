package uz.pdp.codingbat.service;

import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.UserDTO;

import java.util.List;

public interface UserService {


    ApiResult add( UserDTO userDTO);


    List<UserDTO> getAll();


    UserDTO get( String username);


    ApiResult edit( String username,
                    UserDTO languageDTO);

    ApiResult delete( String username);
}
