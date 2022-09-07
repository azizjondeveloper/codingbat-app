package uz.pdp.codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SignDTO;
import uz.pdp.codingbat.service.AuthService;

import javax.validation.Valid;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public HttpEntity<?> signUp(@Valid @RequestBody SignDTO signDTO) {
        ApiResult result = authService.register(signDTO);
        return ResponseEntity
                .status(result.isSuccess() ? 200 : 409)
                .body(result);
    }

    @PostMapping("/sign-in")
    public ApiResult signIn(@Valid @RequestBody SignDTO signDTO) {
        return authService.signIn(signDTO);
    }
}
