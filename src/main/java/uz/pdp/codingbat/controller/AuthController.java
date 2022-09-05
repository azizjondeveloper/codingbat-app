package uz.pdp.codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SignDTO;
import uz.pdp.codingbat.service.AuthService;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping(value = AuthController.AUTH_CONTROLLER_BASE_PATH)
@RestController
@RequiredArgsConstructor
public class AuthController {
    public static final String AUTH_CONTROLLER_BASE_PATH="/api/auth";
    public static final String VERIFICATION_EMAIL_PATH="/verification-email";
    public static final String SIGN_UP_PATH="/sign-up";
    public static final String SIGN_IN_PATH="/sign-in";


    private final AuthService authService;

    @PostMapping(value = SIGN_UP_PATH)
    public HttpEntity<?> signUp(@Valid @RequestBody SignDTO signDTO) {
        ApiResult result = authService.register(signDTO);
        return ResponseEntity
                .status(result.isSuccess() ? 200 : 409)
                .body(result);
    }

    @PostMapping(value = SIGN_IN_PATH)
    public ApiResult signIn(@Valid @RequestBody SignDTO signDTO) {
        return authService.signIn(signDTO);
    }

    @GetMapping(value = VERIFICATION_EMAIL_PATH)
    public ApiResult verificationEmail(@RequestParam UUID code){
        return authService.verificationEmail(code);
    }

}
