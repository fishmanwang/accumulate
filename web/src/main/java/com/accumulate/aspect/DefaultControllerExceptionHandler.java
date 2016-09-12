package com.accumulate.aspect;

import com.accumulate.base.RestResult;
import com.accumulate.base.ResultCode;
import com.accumulate.exception.ApplicationException;
import com.accumulate.exception.CommonErrorCode;
import com.accumulate.exception.ValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统一处理controller抛出的异常
 * Created by tjwang on 2016/9/12.
 */
@ControllerAdvice(annotations = {Controller.class, RestController.class})
public class DefaultControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(DefaultControllerExceptionHandler.class);



    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<RestResult> handlerException(Exception e) {
        logger.error("handlerException", e);
        RestResult result = RestResult.fail(ResultCode.ERROR, e.getMessage());
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<RestResult> handleApplicationException(ApplicationException ex) {
        logger.error("handleApplicationException", ex);
        RestResult result = new RestResult();
        if (ex.getValidationErrors().isEmpty()) {
            result.setCode(ResultCode.ERROR);
        } else {
            result.setCode(ResultCode.VALIDATION_ERROR);
        }
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestResult> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.error("handleMethodArgumentNotValidException", ex);
        ApplicationException applicationException = new ApplicationException(CommonErrorCode.VALIDATION_ERROR, ex);
        if (ex.getBindingResult() != null) {
            for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
                if (objectError instanceof FieldError) {
                    FieldError fieldError = (FieldError) objectError;
                    String key = fieldError.getField();
                    String message = fieldError.getDefaultMessage();

                    ValidationError validationError = ValidationError.build(key, message);
                    applicationException.getValidationErrors().add(validationError);
                }
            }
        }
        return handleApplicationException(applicationException);
    }


}
