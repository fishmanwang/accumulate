package com.accumulate.aspect;

import com.accumulate.base.ErrorData;
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
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
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
        return doHandlerApplicationException(ex);
    }

    /**
     * 使用@Valid注解的Controller的参数，校验失败后，跑出此异常。
     * @param ex
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<RestResult> handleBindException(BindException ex) {
        logger.error("handleBindException", ex);
        ApplicationException applicationException = handleBindingResult(ex.getBindingResult(), ex);
        return doHandlerApplicationException(applicationException);
    }

    /**
     * 使用@RequestBody @Valid注解的Controller参数，校验失败后，抛出此异常。
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestResult> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.error("handleMethodArgumentNotValidException", ex);
        ApplicationException applicationException =  handleBindingResult(ex.getBindingResult(), ex);
        return doHandlerApplicationException(applicationException);
    }

    private ApplicationException handleBindingResult(BindingResult bindingResult, Exception e) {
        ApplicationException applicationException = new ApplicationException(CommonErrorCode.VALIDATION_ERROR, e);
        if (bindingResult == null) {
            return applicationException;
        }

        for (ObjectError objectError : bindingResult.getAllErrors()) {
            if (objectError instanceof FieldError) {
                FieldError fieldError = (FieldError) objectError;
                String key = fieldError.getField();
                String message = fieldError.getDefaultMessage();

                ValidationError validationError = ValidationError.build(key, message);
                applicationException.getValidationErrors().add(validationError);
            }
        }
        return applicationException;
    }

    private ResponseEntity<RestResult> doHandlerApplicationException(ApplicationException ex) {
        RestResult result = new RestResult();
        if (ex.getValidationErrors().isEmpty()) {
            result.setCode(ResultCode.ERROR);
        } else {
            result.setCode(ResultCode.VALIDATION_ERROR);
        }
        ErrorData data = convertToErrorData(ex);
        result.setData(data);
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

    private static ErrorData convertToErrorData(ApplicationException ex) {
        ErrorData data = new ErrorData();
        data.setErrorCode(ex.getErrorCode().getCode());
        data.setErrorMsg(ex.getErrorCode().getMessage());
        data.setValidationErrors(ex.getValidationErrors());
        StringBuffer shortSb = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        for (StackTraceElement stack : ex.getStackTrace()) {
            sb.append(stack);
            sb.append("\r\n");
            if (stack.toString().contains("com.accumulate")) {
                shortSb.append(stack);
                sb.append("\r\n");
            }
        }
        data.setShortStack(shortSb.toString());
        data.setFullStack(sb.toString());
        return data;
    }


}
