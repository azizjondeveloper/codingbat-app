package uz.pdp.codingbat.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.UserDTO;

import java.util.List;

@RequestMapping("/auth")
public interface UserController {
    @PostMapping
    ApiResult add(@RequestBody UserDTO userDTO);

    @GetMapping
    List<UserDTO> getAll();

    @GetMapping("/{username}")
    UserDTO get(@PathVariable String username);

    @PutMapping("/{username}")
    ApiResult edit(@PathVariable String username,
                   @RequestBody UserDTO languageDTO);

    @DeleteMapping("/{username}")
    ApiResult delete(@PathVariable String username);
}
