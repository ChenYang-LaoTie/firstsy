package com.example.demo.modules.common.controller;

import com.example.demo.modules.common.vo.Result;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: ExceptionHandlerController
 * @Author ChenYang
 * @Date 2020/8/26   7:35 下午
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlerController {

    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public Result<String> handle403() {
        return new Result<>(Result.ResultStatus.FAILD.status, "", "/common/403");
    }
}
