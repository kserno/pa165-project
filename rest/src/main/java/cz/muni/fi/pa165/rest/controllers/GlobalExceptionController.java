package cz.muni.fi.pa165.rest.controllers;

import cz.muni.fi.pa165.rest.ApiError;
import cz.muni.fi.pa165.rest.exceptions.GlobalException;
import cz.muni.fi.pa165.rest.exceptions.WrongCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    ApiError handleException(GlobalException ex) {
        ApiError apiError = new ApiError();
        apiError.setErrors(Arrays.asList(ex.getMessage()));
        return apiError;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    ApiError handleWrongCredentialsException(WrongCredentialsException e) {
        ApiError apiError = new ApiError();
        apiError.setErrors(Arrays.asList("Wrong credentials"));
        return apiError;
    }
}
