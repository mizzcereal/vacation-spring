package com.example.my.common.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.my.common.dto.ResponseDTO;
import com.example.my.common.exception.BadRequestException;

@RestControllerAdvice // handler를 만들시 @RestControllerAdvice 사용
public class RestExceptionHandler {

    // RestController니까 ResponseEntity 사용
    @ExceptionHandler(BadRequestException.class) // BadRequestException 발생시 아래함수를 실행
    public ResponseEntity<?> handleBadRequestException(Exception exception) {
        exception.printStackTrace();
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(1)
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception) {
        exception.printStackTrace();
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(1)
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
