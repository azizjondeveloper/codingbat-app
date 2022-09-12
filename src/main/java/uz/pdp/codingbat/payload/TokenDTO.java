package uz.pdp.codingbat.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenDTO {

    private String accessToken;

    private String refreshToken;

    private final String tokenType = "Bearer ";
}
