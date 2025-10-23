package za.ac.cput.wisebank.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Malformed JSON request or invalid field type");
        if (ex.getCause() != null) {
            body.put("details", ex.getCause().getMessage());
        } else {
            body.put("details", ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity<?> handleJsonMapping(JsonMappingException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "JSON mapping error");
        body.put("details", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler({NumberFormatException.class, IllegalArgumentException.class})
    public ResponseEntity<?> handleNumberFormat(RuntimeException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Invalid input value");
        body.put("details", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Validation failed");
        body.put("details", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleOther(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Internal server error");
        body.put("details", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
//guys check if this page will show up in the final project
//13
