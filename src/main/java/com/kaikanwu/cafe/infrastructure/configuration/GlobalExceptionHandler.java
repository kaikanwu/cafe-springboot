package com.kaikanwu.cafe.infrastructure.configuration;

import com.kaikanwu.cafe.infrastructure.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

import static com.kaikanwu.cafe.infrastructure.response.ResponseCode.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Response handlerError(ConstraintViolationException e) {
        log.error("参数校验失败", e);
        String message = String.format("参数校验失败: %s", e.getMessage());
        return Response.error(Response.FAILURE_CODE, message);
    }

    @ExceptionHandler
    public Response handlerError(UnsupportedOperationException e) {
        log.error("不支持的操作", e);
        String message = String.format("操作失败：%s", e.getMessage());
        return Response.error(Response.FAILURE_CODE, message);
    }

    @ExceptionHandler
    public Response handlerError(EntityNotFoundException e) {
        log.error("未查询到信息", e);
        String message = String.format("操作失败: %s", e.getMessage());
        return Response.error(Response.FAILURE_CODE, message);
    }

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
