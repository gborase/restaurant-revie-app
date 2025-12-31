package com.ganeshtech.reviewplatform.controllers;

import com.ganeshtech.reviewplatform.domain.dtos.ErrorDTO;
import com.ganeshtech.reviewplatform.exception.BaseException;
import com.ganeshtech.reviewplatform.exception.StorageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@Slf4j
public class ErrorController {

    @ExceptionHandler(StorageException.class)
    public ResponseEntity<ErrorDTO> handleStorageException(StorageException ex){
        log.error("Caught Storage error "+ex);
        ErrorDTO build = ErrorDTO.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Unable to save the resource")
                .build();

        return new ResponseEntity<>(build,HttpStatus.INTERNAL_SERVER_ERROR);


    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorDTO> handleBaseException(BaseException ex){
        log.error("Caught Base Excetion error "+ex);
        ErrorDTO build = ErrorDTO.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Unable to save the resource")
                .build();
        return new ResponseEntity<>(build,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception ex){
        log.error("Caught Excetion error "+ex);
        ErrorDTO build = ErrorDTO.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Unable to save the resource")
                .build();
        return new ResponseEntity<>(build,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
