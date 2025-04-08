package com.example.atividadePontuada.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Map;
import java.util.Objects;

@RestControllerAdvice // Intercepta as exceções lançadas pelos controllers
public class GlobalExceptionHandler{
    // Intercepta as exceções lançadas pelos controllers e retorna uma resposta personalizada
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException error){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", error.getMessage()));
    }

    // Intercepta as exceções lançadas pelos controllers e retorna uma resposta personalizada
    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<Map<String, Object>> handleEmailJaCadastradoException(EmailJaCadastradoException error){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
            .body(Map.of("mensagem", error.getMessage()));
    }

    // Intercepta as exceções lançadas pelos controllers e retorna uma resposta personalizada
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> hadlerMethodArgumentNotValidException(MethodArgumentNotValidException error){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", Objects.requireNonNull(error.getFieldError()).getDefaultMessage()));
    }

    // Intercepta as exceções lançadas pelos controllers e retorna uma resposta personalizada
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNoResourceFoundException(NoResourceFoundException error){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
            .body(Map.of("mensagem", error.getMessage()));
    }

    // Intercepta as exceções lançadas pelos controllers e retorna uma resposta personalizada
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException error){
        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(Map.of("mensagem", error.getMessage()));
    }
}
