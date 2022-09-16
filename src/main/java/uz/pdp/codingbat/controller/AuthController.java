package uz.pdp.codingbat.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SignDTO;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping(AuthController.AUTH_CONTROLLER_BASE_PATH)

public interface AuthController {

    String AUTH_CONTROLLER_BASE_PATH="/api/auth";
    String VERIFICATION_EMAIL_PATH="/verification-email";
    String SIGN_UP_PATH="/sign-up";
    String SIGN_IN_PATH="/sign-in";


    @PostMapping(SIGN_UP_PATH)
    ApiResult<?> signUp(@Valid @RequestBody SignDTO signDTO);

    @PostMapping(SIGN_IN_PATH)
    ApiResult signIn(@Valid @RequestBody SignDTO signDTO);

    @GetMapping(value = VERIFICATION_EMAIL_PATH)
    ApiResult verificationEmail(@RequestParam UUID code);


}
