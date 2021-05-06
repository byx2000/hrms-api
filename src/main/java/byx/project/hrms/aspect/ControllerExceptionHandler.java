package byx.project.hrms.aspect;

import byx.project.hrms.common.Result;
import byx.project.hrms.common.Status;
import byx.project.hrms.exception.BizException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 对Controller的异常进行统一处理
 *
 * @author byx
 */
@RestControllerAdvice
public class ControllerExceptionHandler {
    private String getErrorMessage(BindException e) {
        return e.getBindingResult().getFieldError() != null ? e.getBindingResult().getFieldError().getDefaultMessage() : "";
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(BindException.class)
    public Result<?> parameterException(BindException e) {
        return Result.fail(Status.PARAMETER_ERROR, getErrorMessage(e));
    }

    /**
     * 请求异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<?> requestException(HttpMessageNotReadableException e) {
        e.printStackTrace();
        return Result.fail(Status.BAD_REQUEST, e.getMessage());
    }

    /**
     * 业务逻辑异常
     */
    @ExceptionHandler(BizException.class)
    public Result<?> bizException(BizException e) {
        e.printStackTrace();
        return Result.fail(e.getStatus(), e.getData());
    }

    /**
     * 未知异常
     */
    @ExceptionHandler(Exception.class)
    public Result<?> internalException(Exception e) {
        e.printStackTrace();
        return Result.fail(Status.INTERNAL_ERROR);
    }
}
