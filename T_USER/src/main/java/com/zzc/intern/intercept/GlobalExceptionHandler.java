package com.zzc.intern.intercept;

import com.zzc.intern.exception.BusinessException;
import com.zzc.intern.exception.CommonErrorCode;
import com.zzc.intern.exception.ErrorCode;
import com.zzc.intern.exception.RestErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 */
@RestControllerAdvice //与@Exceptionhandler配合使用实现全局异常处理
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(com.zzc.intern.intercept.GlobalExceptionHandler.class);

    //捕获异常
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse processException(HttpServletRequest request,
                                              HttpServletResponse response,
                                              Exception e) {
        //解析异常信息
        //如果是系统自定义异常，直接取出errCode和errMessage
        if (e instanceof BusinessException) {
            LOGGER.info(e.getMessage(), e);
            //解析系统自定义异常信息
            ErrorCode errorCode = ((BusinessException) e).getErrorCode();
            //错误代码
            int code = errorCode.getCode();
            //错误信息
            String desc = errorCode.getDesc();
            return new RestErrorResponse(code, desc);
        }

        LOGGER.error("系统异常：", e);
        //统一定义为99999系统未知错误
        return new RestErrorResponse(CommonErrorCode.UNKNOWN.getCode(), CommonErrorCode.UNKNOWN.getDesc());

    }
}
