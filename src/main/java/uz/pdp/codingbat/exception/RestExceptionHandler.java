package uz.pdp.codingbat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.codingbat.payload.ApiResult;

@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(value = InputDataExistsException.class)
    public ResponseEntity<ApiResult> exceptionHandle(InputDataExistsException ex) {
        System.out.println(ex);
        ApiResult apiResult = new ApiResult(false, ex.getMessage());
        return new ResponseEntity<>(apiResult, HttpStatus.CONFLICT);
    }
}
