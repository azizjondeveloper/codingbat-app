package uz.pdp.codingbat.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiResult {

    private boolean success;

    private String message;

    private Object data;

    public ApiResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
