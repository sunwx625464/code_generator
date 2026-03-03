package com.robert.codegenerator.common.exceptions;

import com.robert.codegenerator.common.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * @author sunweixin
 * @date 2024/7/27
 * @description 全局异常处理类
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result<?> handleBizException(BusinessException e){
        log.warn("业务异常: {}", e.getMessage());
        return Result.error(e.getCode(),e.getMessage());
    }

    /**
     * 处理参数校验异常 @Valid, @RequestBody 校验失败
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // HTTP 400
    public Result<?> handleValidationException(MethodArgumentNotValidException e) {
        // 提取所有校验失败的字段信息，拼接成字符串
        String errorMsg = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining("; "));

        log.warn("参数校验失败: {}", errorMsg);
        // 通常校验失败返回 400 或特定的业务码，这里示例用 400
        return Result.error(400, "参数校验失败: " + errorMsg);
    }

    /**
     * 处理绑定异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<?> handleBindException(BindException e) {
        String errorMsg = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining("; "));
        return Result.error(400, "参数绑定失败: " + errorMsg);
    }

    /**
     * 处理其他所有未知异常 (兜底)
     * 对应系统 Bug、数据库连接断开、空指针等
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // HTTP 500
    public Result<?> handleOtherException(Exception e) {
        // 必须打印完整堆栈
        log.error("系统内部异常:", e);

        // 生产环境隐藏具体异常信息，防止泄露系统细节
        String msg = "系统繁忙，请稍后再试";
        // 开发环境可以返回具体错误：e.getMessage()

        return Result.error(500, e.getMessage());
    }
}
