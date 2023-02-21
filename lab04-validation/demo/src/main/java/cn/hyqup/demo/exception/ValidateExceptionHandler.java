package cn.hyqup.demo.exception;

import cn.hyqup.demo.result.Result;
import cn.hyqup.demo.result.ResultCode;
import cn.hyqup.validator.exception.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * Copyright © 2023NCS. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2023/2/4
 * @description:
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@Slf4j
public class ValidateExceptionHandler {

    /**
     * 处理使用RequestBody传递参数产生的异常信息。
     * @param exception
     * @param response
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception, HttpServletResponse response) {
        return  Result.fail(ResultCode.REQUEST_BINDING);
    }

    /**
     * 处理使用RequestParam传递参数产生的异常信息
     * @param exception
     * @param response
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException exception, HttpServletResponse response) {
        return  Result.fail(ResultCode.REQUEST_BINDING);

    }

    /**
     * jsr 303 校验抛出的异常
     * @param e
     * @return
     * @param <T>
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public <T> Result<T> handleBindException(BindException e) {
        log.error("BindException:{}", e.getMessage());
        String msg = e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining("；"));
        return Result.fail(ResultCode.PARAM_ERROR, msg);
    }

    /**
     * RequestParam参数的校验
     *
     * @param e
     * @param <T>
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public <T> Result<T> handleConstraintViolationException(ConstraintViolationException e) {
        log.error("ConstraintViolationException:{}", e.getMessage());
        String msg = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("；"));
        return Result.fail(ResultCode.PARAM_ERROR, msg);
    }

    /**
     * RequestBody参数的校验
     *
     * @param e
     * @param <T>
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public <T> Result<T> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException:{}", e.getMessage());
        String msg = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining("；"));
        return Result.fail(ResultCode.PARAM_ERROR, msg);
    }


    /**
     * 自定义注解参数校验
     * @param e
     * @return
     * @param <T>
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidateException.class)
    public <T> Result<T> handleValidateException(ValidateException e) {
        log.error("ValidateException:{}", e.getMessage());
        String msg =e.getMessage();
        return Result.fail(ResultCode.PARAM_ERROR, msg);
    }

}
