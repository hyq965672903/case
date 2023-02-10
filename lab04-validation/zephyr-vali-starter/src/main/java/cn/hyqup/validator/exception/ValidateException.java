package cn.hyqup.validator.exception;

/**
 * Copyright © 2023NCS. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2023/2/10
 * @description:
 */
public class ValidateException extends RuntimeException{
    public ValidateException(String message) {
        super(message);
    }
}
