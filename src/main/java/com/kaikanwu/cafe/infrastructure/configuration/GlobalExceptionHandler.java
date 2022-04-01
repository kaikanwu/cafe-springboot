package com.kaikanwu.cafe.infrastructure.configuration;

import com.kaikanwu.cafe.infrastructure.response.Response;
import com.kaikanwu.cafe.infrastructure.response.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.UnexpectedTypeException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.kaikanwu.cafe.infrastructure.response.ResponseCode.*;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Response handlerError(MissingServletRequestParameterException e) {
        log.error("Missing request param", e);
        String message = String.format("Missing request param: %s", e.getParameterName());
        return Response.error(Response.FAILURE_CODE, message);
    }
//
//     @ExceptionHandler
//    public Response handlerError(MethodArgumentNotValidException e) {
//        log.error("Param not valid", e);
//        String message = String.format("Param not valid: %s", e.getParameter());
//        return Response.error(Response.FAILURE_CODE, message);
//    }
//
//    @ExceptionHandler
//    public Response handlerError(UnexpectedTypeException e) {
//        log.error("Param not valid", e);
//        String message = String.format("Param not valid: %s", e.getMessage());
//        return Response.error(Response.FAILURE_CODE, message);
//    }

    @ExceptionHandler
    public Response handlerError(BindException e) {
        log.error("Param not valid", e);
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", "));
        return Response.error(Response.FAILURE_CODE, message);
    }

    @ExceptionHandler
    public Response unknownError(Exception e) {
        log.error(INTERNAL_SERVER_ERROR.message(), e);
        return Response.error(INTERNAL_SERVER_ERROR.code(), INTERNAL_SERVER_ERROR.message());
    }
}
