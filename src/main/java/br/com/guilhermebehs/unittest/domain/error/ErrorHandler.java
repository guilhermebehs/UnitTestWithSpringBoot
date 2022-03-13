package br.com.guilhermebehs.unittest.domain.error;

import br.com.guilhermebehs.unittest.domain.entity.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value={ BadRequestException.class })
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
        String message = ex.getMessage();
        System.out.println(ex.getMessage());
        var error = new ErrorDto(message, HttpStatus.BAD_REQUEST.value());
        return handleExceptionInternal(ex, error,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

   @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
       BindingResult result = exception.getBindingResult();
       List<FieldError> fieldErrors = result.getFieldErrors();

       String field = fieldErrors.get(0).getField().replaceAll(
               "([a-z])([A-Z]+)", "$1_$2")
               .toLowerCase();

       String error = fieldErrors.get(0).getDefaultMessage();
       String message = field +" "+ error;
        return new ResponseEntity(
                new ErrorDto(message, HttpStatus.BAD_REQUEST.value()),
                headers,
                HttpStatus.BAD_REQUEST);
    }

}
