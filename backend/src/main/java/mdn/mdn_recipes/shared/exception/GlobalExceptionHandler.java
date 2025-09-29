package mdn.mdn_recipes.shared.exception;

import mdn.mdn_recipes.application.dto.generic.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {

        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(ex.getMessage()));
    }

}
