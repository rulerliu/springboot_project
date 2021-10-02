package com.liuwq.demo.exception;

import com.liuwq.demo.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
@Slf4j
public class GateWayExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public CommonResult handle(NullPointerException e) {
        return CommonResult.failed("空指针异常");
    }
    @ResponseBody
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public CommonResult handle(SQLIntegrityConstraintViolationException e) {
        log.error("唯一性索引冲突:"+e.getMessage(),e);
        return CommonResult.failed("唯一性索引冲突");
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult handle(Exception e) {
        log.error("系统出现异常:"+e.getMessage(),e);
        return CommonResult.failed("系统出现异常");
    }


}