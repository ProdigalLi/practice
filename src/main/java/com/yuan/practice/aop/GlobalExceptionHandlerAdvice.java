package com.yuan.practice.aop;

import com.yuan.practice.result.CommonResult;
import com.yuan.practice.result.ResultConstant;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.security.auth.message.AuthException;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.Optional;

/**
 * @author Yuan
 */
@ControllerAdvice
@Component
public class GlobalExceptionHandlerAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public CommonResult<Void> handlerIllegalArgumentException(IllegalArgumentException ex) {
        return CommonResult.operateFailWithMessage(ex.getMessage());
    }


    @ExceptionHandler(IllegalStateException.class)
    @ResponseBody
    public CommonResult<Void> handlerIllegalStateException(IllegalStateException ex) {
        return CommonResult.operateFailWithMessage(ex.getMessage());
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    @ResponseBody
    public CommonResult<Void> handlerSqlSyntaxErrorException(SQLSyntaxErrorException ex) {
        return CommonResult.operateFailWithMessage(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResult<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        Optional<String> errors = fieldErrors.stream().map(FieldError::getDefaultMessage).reduce((a, b) -> a + " \n" + b);
        return CommonResult.operateFailWithMessage(errors.orElse("参数错误"));
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public CommonResult<Void> handleValidationException(ValidationException ex) {
        return CommonResult.operateFailWithMessage(ex.getCause().getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public CommonResult<Void> handleConstraintViolationException(ConstraintViolationException ex) {
        return CommonResult.operateFailWithMessage(ex.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public CommonResult<Void> handlerNoFoundException(Exception ex) {
        return CommonResult.operateFailWithMessage("路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public CommonResult<Void> handleDuplicateKeyException(DuplicateKeyException ex) {
        return CommonResult.operateFailWithMessage("数据重复，请检查后提交");
    }

    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public CommonResult<Void> handleAuthException(AuthException ex) {
        return new CommonResult<>(ResultConstant.UNAUTHORIZED_CODE, ex.getMessage(), false);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResult<Void> handleException(Exception ex) {
        return CommonResult.operateFailWithMessage("系统繁忙，请稍后再试！错误信息：" + ex.getLocalizedMessage());
    }
}
