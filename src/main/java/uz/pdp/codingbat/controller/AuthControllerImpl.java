package uz.pdp.codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SignDTO;
import uz.pdp.codingbat.service.AuthService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController{

    private final AuthService authService;

    @Override
    public ApiResult<?> signUp(SignDTO signDTO) {
        return authService.register(signDTO);
    }

    @Override
    public ApiResult signIn(SignDTO signDTO) {
        return authService.signIn(signDTO);
    }

    @Override
    public ApiResult verificationEmail(UUID code) {
        return authService.verificationEmail(code);
    }
}
