package uz.pdp.codingbat.service;

import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SignDTO;
import uz.pdp.codingbat.payload.TokenDTO;

import java.util.UUID;


public interface AuthService {


    ApiResult<String> register(SignDTO signDTO);

    ApiResult<TokenDTO> signIn(SignDTO signDTO);

    ApiResult<String> verificationEmail(UUID code);


}
