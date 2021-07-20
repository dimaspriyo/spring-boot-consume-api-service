package com.example.demo.exception;

import com.example.demo.util.ResponseUtil;
import io.jsonwebtoken.JwtException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    ResponseUtil responseUtil;

    @ExceptionHandler(JwtException.class)
    protected ResponseEntity<Object> handleJWTException(JwtException exception) throws ParseException {
        exception.printStackTrace();
        return responseUtil.buildBadRequestResponse(exception.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity<Object> handleAuthenticationException(AuthenticationException exception) throws ParseException {
        exception.printStackTrace();
        return responseUtil.buildBadRequestResponse(exception.getMessage());
    }

}
