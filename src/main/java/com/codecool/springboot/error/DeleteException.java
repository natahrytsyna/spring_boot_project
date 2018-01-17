package com.codecool.springboot.error;

import com.codecool.springboot.logger.LoggerService;
import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class DeleteException extends ResponseEntityExceptionHandler {

    private Logger logger;


    public DeleteException(LoggerService loggerService) {
        this.logger = loggerService.getLogger();
    }

    @DeleteMapping("")
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Can not delete data that does not exist")
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public void conflict(){
        logger.error("Data does not exist");
    }
}

