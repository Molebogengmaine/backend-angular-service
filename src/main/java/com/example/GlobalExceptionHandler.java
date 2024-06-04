package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URISyntaxException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static ResponseEntity<Object> reply(Exception e, ServletWebRequest req, int statusCode, String reason) throws URISyntaxException {
        var problem = RegisterResponse.builder().statusCode(statusCode).message(reason + " " + e.getMessage()).success(false).build();
        return ResponseEntity.status(statusCode).body(problem);
    }

    private static ResponseEntity<Object> replyNoContent(Exception e, ServletWebRequest req, int statusCode, String reason) throws URISyntaxException {
        var problem = RegisterResponse.builder().statusCode(statusCode).message(reason + " " + e.getMessage()).success(false).build();
        return ResponseEntity.status(200).body(problem);
    }



 /*   @ExceptionHandler({PrintForexReceiptBadRequestException.class})
    public ResponseEntity<Object> handleIllegalState(Exception e, WebRequest req) throws URISyntaxException {
        log.info("Bad request*****", e.getMessage(), e);
        return reply(e, (ServletWebRequest) req, 400, "");
    }*/

    @ExceptionHandler({PhoneNumberException.class})
    public ResponseEntity<Object> handleFailedPrint(Exception e, WebRequest req) throws URISyntaxException {
        log.info("Phone number is greater than 10: {}", e.getMessage(), e);
        return reply(e, (ServletWebRequest) req, 400, "");
    }
}