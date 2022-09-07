package uz.pdp.codingbat.payload;

import lombok.Getter;

import javax.validation.constraints.*;

@Getter
public class SignDTO {

    @NotBlank(message = "Oka email bo'sh bo'lmasinda")
    @Email(message = "Oka email berish kerakda", regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
    private String username;

    @NotBlank(message = "Oka parol bo'sh bo'lmasinda")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+=])(?=\\S+$).{8,}$")
    private String password;
}
