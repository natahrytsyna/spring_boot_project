package com.codecool.springboot.error;

import com.codecool.springboot.logger.LoggerService;
import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class UniqueException extends ResponseEntityExceptionHandler {

    private Logger logger;

    public UniqueException(LoggerService loggerService) {
        this.logger = loggerService.getLogger();
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "This data already exists")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict(){
        logger.error("Unique Exception: data already exists");
    }
}

